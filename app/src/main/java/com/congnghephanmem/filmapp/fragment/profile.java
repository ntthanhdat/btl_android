package com.congnghephanmem.filmapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.congnghephanmem.filmapp.Model.GetData;
import com.congnghephanmem.filmapp.R;
import com.congnghephanmem.filmapp.SignIn.SignInActivity;
import com.congnghephanmem.filmapp.SignUp.SignUpActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profile.
     */
    // TODO: Rename and change types and number of parameters
    public static profile newInstance(String param1, String param2) {
        profile fragment = new profile();
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
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @BindView(R.id.btn_profileUser)
    Button btn_profile;
    @BindView(R.id.btn_phim_da_xem)
    Button btn_phimDaXem;
    @BindView(R.id.btn_sign_in)
    Button btn_dangNhap;
    @BindView(R.id.btn_sign_up)
    Button btn_dangKy;
    @BindView(R.id.btn_phim_out)
    Button btn_out;
    @BindView(R.id.tv_name_user)
    TextView tvNameUser;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.img_avatar)
    ImageView imageView;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        GetData getData=new GetData();
        tvNameUser.setText(getData.ten);
        tvEmail.setText(getData.email);
        if (tvNameUser.getText()!=""){


            btn_dangKy.setVisibility(View.GONE);
            btn_dangNhap.setVisibility(View.GONE);
        }else{
            tvNameUser.setText("Guest");
            Log.d("TAG", "chua co user");
            btn_out.setVisibility(View.GONE);
            btn_profile.setVisibility(View.GONE);
            btn_phimDaXem.setVisibility(View.GONE);
        }

        if (getData.avatar!=null){
            Picasso.get().load(getData.avatar).into(imageView);
        }else{

        }
        btn_dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SignInActivity.class));
//                getActivity().finish();
            }
        });

        btn_dangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SignUpActivity.class));
//                getActivity().finish();
            }
        });

        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearUser();
            }
        });
    }

    public void clearUser(){
        GetData a= new GetData();
        a.clear();

        GetData getData=new GetData();
        tvNameUser.setText(getData.ten);
        tvEmail.setText(getData.email);
        if (tvNameUser.getText()!=""){


            btn_dangKy.setVisibility(View.GONE);
            btn_dangNhap.setVisibility(View.GONE);
        }else{
            tvNameUser.setText("Guest");
            Log.d("TAG", "chua co user");
            btn_out.setVisibility(View.GONE);
            btn_profile.setVisibility(View.GONE);
            btn_phimDaXem.setVisibility(View.GONE);
        }

        if (getData.avatar!=null){
            Picasso.get().load(getData.avatar).into(imageView);
        }else{

        }
    }
}