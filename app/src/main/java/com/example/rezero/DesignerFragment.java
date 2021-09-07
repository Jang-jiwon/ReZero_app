package com.example.rezero;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DesignerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DesignerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<ListV> designerDataList;

    private View view;



    public DesignerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DesignerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DesignerFragment newInstance(String param1, String param2) {
        DesignerFragment fragment = new DesignerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_designer, container, false);

        this.InitializeMovieData();

        ListView listView = (ListView)view.findViewById(R.id.listView);
        final ListAdapter listAdapter = new ListAdapter(getContext(),designerDataList);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getContext().getApplicationContext(),
                        listAdapter.getItem(position).getDesignerName(),
                        Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    public void InitializeMovieData()
    {
        designerDataList = new ArrayList<ListV>();

        //movieDataList.add(new ListV(R.drawable.pic1, "미션임파서블","15세 이상관람가"));
        for (int i=0;i<20;i++){
            designerDataList.add(new ListV( "디자이너명","디자이너소개"));
        }
    }
}