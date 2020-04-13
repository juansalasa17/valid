package com.valid.prueba.adapter;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.valid.prueba.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import entities.ListArtist;
import services.CallServiceRest;
import services.ICallBackServiceRest;
import utilities.ConstantsMessage;
import utilities.ConstantsServices;
import utilities.EnumThreads;
import utilities.Message;
import utilities.Utilities;

import static utilities.Message.logMessageException;

public class ListOneActivity extends AppCompatActivity implements ICallBackServiceRest {

    private List<ListArtist> list;
    private RecyclerView lv;
    private AdapterListArtist adapterListArtist;
    private ArrayList<ListArtist> filterReadList;

    private String valueName;
    private String valueUrl;
    private EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_one);
        lv = findViewById(R.id.recyclerCatalog);
        lv.setHasFixedSize(true);
        search = findViewById(R.id.txtSearch);
        loadArtist();
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    //Load environment
    private void loadArtist() {
        try {
            list = new ArrayList<>();
            try {
                if (Utilities.isNetworkAvailable(this))
                    Message.showMessage(getResources().getString(R.string.msg_no_network), this, ConstantsMessage.IMAGE_ERROR);
                else
                    new CallServiceRest().getArtis(this, this);
            } catch (Exception e) {
                logMessageException(getClass(), e);
            }
        } catch (Exception e) {
            Message.logMessageException(getClass(), e);
        }
    }

    @Override
    public void serviceResultRest(JSONObject data, EnumThreads method) {
        try {

            if (data == null || data.toString().equals(ConstantsServices.RESPONSE_SERVICE_EMPTY)) {
                Message.showMessage(ConstantsMessage.ERROR_SERVICE, this, ConstantsMessage.IMAGE_ERROR);
            } else {
                if (method == EnumThreads.GET_LIST_ARTIST) {
                    methodGetListArtist(data);
                }
            }
        } catch (
                Exception e) {
            logMessageException(getClass(), e);
        }

    }

    //method GetList Artist
    private void methodGetListArtist(JSONObject data) {

        try {
            JSONObject objectData = data.getJSONObject(ConstantsServices.RESPONSE_SERVICE_DESCRIPTION);

            JSONArray parameters = objectData.getJSONArray(ConstantsServices.RESPONSE_SERVICE_DATA_RESULT);
            //JSONArray parameters1 = objectData.getJSONArray(ConstantsServices.RESPONSE_SERVICE_DATA_RESULT1);

            System.out.println("Datos parameters:::: " + parameters);
            //System.out.println("Datos parameters 1:::: " + parameters1);

            list = new ArrayList<>();
            for (int i = 0; i < parameters.length(); i++) {
                JSONObject parametersJSONObject = parameters.getJSONObject(i);

                ListArtist objectOrder = new ListArtist(parametersJSONObject.getString(ConstantsServices.RESPONSE_SERVICE_NAME),
                        parametersJSONObject.getString(ConstantsServices.RESPONSE_SERVICE_URL),
                        parametersJSONObject.getString(ConstantsServices.RESPONSE_SERVICE_LISTINER));

                list.add(objectOrder);
            }

            LinearLayoutManager llm = new LinearLayoutManager(this);

            llm.setOrientation(LinearLayoutManager.VERTICAL);

            lv.setLayoutManager(new GridLayoutManager(this, 2));
            adapterListArtist = new AdapterListArtist(list);

            adapterListArtist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {

                        if (filterReadList != null) {
                            int positions = lv.getChildAdapterPosition(v);
                            valueName = filterReadList.get(positions).getName();
                            valueUrl = filterReadList.get(positions).getUrl();
                        } else {
                            int position = lv.getChildAdapterPosition(v);
                            valueName = list.get(position).getName();
                            valueUrl = list.get(position).getUrl();
                        }

                        loadDetail();

                    } catch (Exception ex) {
                        Message.logMessageException(getClass(), ex);
                    }
                }
            });

            lv.setAdapter(adapterListArtist);
        } catch (Exception e) {
            System.out.println("Error recycle:: " + e.getMessage());
            Message.logMessageException(getClass(), e);
        }


    }

    private void loadDetail() {
        try {
            final Dialog dialog = Message.getDialogDetail(ListOneActivity.this);
            final ImageView ivImageProduct = dialog.findViewById(R.id.img_producto_order);
            final TextView txtItem = dialog.findViewById(R.id.tvArtist);
            final TextView txtUrl = dialog.findViewById(R.id.tvUrl);

            ivImageProduct.setImageResource(R.mipmap.music);
            txtItem.setText(valueName);
            txtUrl.setText(valueUrl);


            dialog.findViewById(R.id.btnCloseMessage).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();
        } catch (Exception e) {
            Message.logMessageException(getClass(), e);
        }
    }

    private void filter(String text) {

        try {
            filterReadList = new ArrayList<>();
            filterReadList.clear();

            if (!text.isEmpty()) {
                for (ListArtist item : list) {
                    if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                        filterReadList.add(item);
                    }
                }
                adapterListArtist.filterList(filterReadList);

            }
        } catch (Exception e) {
            Message.logMessageException(getClass(), e);
        }
    }

}