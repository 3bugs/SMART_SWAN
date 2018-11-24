package th.ac.dusit.dbizcom.smartswan.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.glide.slider.library.Animations.DescriptionAnimation;
import com.glide.slider.library.SliderLayout;
import com.glide.slider.library.SliderTypes.DefaultSliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import th.ac.dusit.dbizcom.smartswan.R;
import th.ac.dusit.dbizcom.smartswan.model.DetailsContent;

public class MenuDetailsFragment extends Fragment {

    private static final String TAG = MenuDetailsFragment.class.getName();
    private static final String ARG_TYPE = "type";

    private int mType;
    private SliderLayout mSlider;
    private ViewPager mViewPager;
    private TextView mTitleTextView;
    private List<DetailsContent> mDetailsContentList;

    public MenuDetailsFragment() {
        // Required empty public constructor
    }

    public static MenuDetailsFragment newInstance(int type) {
        MenuDetailsFragment fragment = new MenuDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = getArguments().getInt(ARG_TYPE);
        }

        Toast.makeText(getActivity(), "Type: " + mType, Toast.LENGTH_SHORT).show();

        mDetailsContentList = new ArrayList<>();
        switch (mType) {
            case 0: // sdu
                mDetailsContentList.add(
                        new DetailsContent(
                                "ยุคที่ 1",
                                "ข้อความรายละเอียด ยุคที่ 1",
                                new int[]{
                                        R.drawable.gallery_sdu_1a,
                                        R.drawable.gallery_sdu_1b
                                }
                        )
                );
                mDetailsContentList.add(
                        new DetailsContent(
                                "ยุคที่ 2",
                                "ข้อความรายละเอียด ยุคที่ 2",
                                new int[]{
                                        R.drawable.gallery_sdu_2a
                                }
                        )
                );
                mDetailsContentList.add(
                        new DetailsContent(
                                "ยุคที่ 3",
                                "ข้อความรายละเอียด ยุคที่ 3",
                                new int[]{
                                        R.drawable.gallery_sdu_3a,
                                        R.drawable.gallery_sdu_3b
                                }
                        )
                );
                mDetailsContentList.add(
                        new DetailsContent(
                                "ยุคที่ 4-5",
                                "ข้อความรายละเอียด ยุคที่ 4-5",
                                new int[]{
                                        R.drawable.gallery_sdu_4a,
                                        R.drawable.gallery_sdu_4b,
                                        R.drawable.gallery_sdu_4c
                                }
                        )
                );
                break;
            case 1: // ml
                //todo:
                break;
            case 2: // swan
                //todo:
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTitleTextView = view.findViewById(R.id.title_text_view);
        mTitleTextView.setText(mDetailsContentList.get(0).title);

        ImageView previousImageView = view.findViewById(R.id.previous_image_view);
        previousImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPosition = mViewPager.getCurrentItem();
                if (currentPosition > 0) {
                    mViewPager.setCurrentItem(currentPosition - 1);
                }
            }
        });
        ImageView nextImageView = view.findViewById(R.id.next_image_view);
        nextImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPosition = mViewPager.getCurrentItem();
                if (currentPosition < mDetailsContentList.size() - 1) {
                    mViewPager.setCurrentItem(currentPosition + 1);
                }
            }
        });

        mSlider = view.findViewById(R.id.slider);
        setupImageSlider(view, 0);
        setupViewPager(view);
    }

    private void setupViewPager(@NonNull View view) {
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
                getChildFragmentManager(),
                mDetailsContentList
        );
        mViewPager = view.findViewById(R.id.view_pager);
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mTitleTextView.setText(mDetailsContentList.get(position).title);
                setupImageSlider(getView(), position);
            }
        });
    }

    private void setupImageSlider(View view, int position) {
        //mSlider.setCustomIndicator((PagerIndicator) view.findViewById(R.id.slider_indicator));

        HashMap<String, Integer> imageMap = new HashMap<>();
        int i = 0;
        for (int imageRes : mDetailsContentList.get(position).galleryImages) {
            imageMap.put(String.valueOf(i++), imageRes);
        }

        mSlider.removeAllSliders();
        for (String name : imageMap.keySet()) {
            DefaultSliderView defaultSliderView = new DefaultSliderView(getActivity());
            defaultSliderView.image(imageMap.get(name));
            mSlider.addSlider(defaultSliderView);
        }

        mSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setDuration(4000);
    }

    private static class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private List<DetailsContent> mDetailsContentList;

        MyFragmentPagerAdapter(FragmentManager fm, List<DetailsContent> detailsContentList) {
            super(fm);
            mDetailsContentList = detailsContentList;
        }

        @Override
        public Fragment getItem(int position) {
            Log.i(TAG, "Content => " + mDetailsContentList.get(position).content);

            ContentFragment fragment = ContentFragment.newInstance(
                    mDetailsContentList.get(position).content
            );
            return fragment;
        }

        @Override
        public int getCount() {
            return mDetailsContentList.size();
        }
    }
}
