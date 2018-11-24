package th.ac.dusit.dbizcom.smartswan.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import th.ac.dusit.dbizcom.smartswan.R;

public class MenuFragment extends Fragment implements View.OnClickListener {

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupImageMenu(view);
    }

    private void setupImageMenu(@NonNull View view) {
        ImageView menu01ImageView = view.findViewById(R.id.menu_01_image_view);
        menu01ImageView.setOnClickListener(this);
        ImageView menu02ImageView = view.findViewById(R.id.menu_02_image_view);
        menu02ImageView.setOnClickListener(this);
        ImageView menu03ImageView = view.findViewById(R.id.menu_03_image_view);
        menu03ImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MenuMainFragment fragment = null;

        switch (view.getId()) {
            case R.id.menu_01_image_view:
                fragment = MenuMainFragment.newInstance(0);
                break;
            case R.id.menu_02_image_view:
                fragment = MenuMainFragment.newInstance(1);
                break;
            case R.id.menu_03_image_view:
                fragment = MenuMainFragment.newInstance(2);
                break;
        }

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
