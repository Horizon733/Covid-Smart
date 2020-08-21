package com.example.covidsmart;

import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MaskDetectorFragment extends Fragment {

    private static final String KEY_USE_FACING = "use_facing";
    Fragment cameraFragment;
    Context mContext;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    public MaskDetectorFragment() {
        // Required empty public constructor
    }

    public MaskDetectorFragment(Context context,Fragment fragment) {
        this.cameraFragment = fragment;
        mContext = context;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!= null) {
            fragmentArrayList = savedInstanceState.getParcelable("fragment");
            cameraFragment = fragmentArrayList.get(0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_mask_detector, container, false);
        getFragmentManager().beginTransaction().replace(R.id.container, cameraFragment).commit();
        FloatingActionButton btnSwitchCam = root.findViewById(R.id.fab);


        btnSwitchCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchCamera();
            }
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        getFragmentManager().beginTransaction().replace(R.id.container, cameraFragment).commit();
    }

    public void switchCamera() {
        //useFacing = MainActivity.getCameraFacing();
        Intent intent = getActivity().getIntent();

        if (CameraActivity.useFacing == CameraCharacteristics.LENS_FACING_FRONT) {
            CameraActivity.useFacing = CameraCharacteristics.LENS_FACING_BACK;
        } else {
            CameraActivity.useFacing = CameraCharacteristics.LENS_FACING_FRONT;
        }

        intent.putExtra(KEY_USE_FACING, CameraActivity.useFacing);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

        restartWith(intent);

    }

    private void restartWith(Intent intent) {
        getActivity().finish();
        getActivity().overridePendingTransition(0, 0);
        startActivity(intent);

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        fragmentArrayList.add(cameraFragment);
        outState.putParcelable("fragment", (Parcelable) fragmentArrayList);
    }
}