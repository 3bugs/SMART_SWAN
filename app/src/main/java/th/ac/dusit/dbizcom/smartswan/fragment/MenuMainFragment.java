package th.ac.dusit.dbizcom.smartswan.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import th.ac.dusit.dbizcom.smartswan.R;

public class MenuMainFragment extends Fragment {

    private static final String ARG_TYPE = "type";

    private int mType;

    public MenuMainFragment() {
        // Required empty public constructor
    }

    public static MenuMainFragment newInstance(int type) {
        MenuMainFragment fragment = new MenuMainFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String content = null;
        switch (mType) {
            case 0:
                content = "          มหาวิทยาลัยสวนดุสิตจัดตั้งขึ้นเพื่อเป็นโรงเรียนการเรือนแห่งแรกของประเทศไทย ชื่อ“โรงเรียนมัธยมวิสามัญการเรือน” สังกัดกองอาชีวศึกษา กรมวิชาการ กระทรวงธรรมการ (กระทรวงศึกษาธิการ) เปิดดำเนินการเมื่อวันที่ 17 พฤษภาคม พ.ศ.2477 ที่วังกรมหลวงชุมพรเขตอุดมศักดิ์ (ปัจจุบันเป็นที่ตั้งของมหาวิทยาลัย-เทคโนโลยีราชมงคล วิทยาเขตพณิชยการพระนคร) มีจุดมุ่งหมายเพื่ฝึกอบรมการบ้านการเรือนสำหรับสตรีหลักสูตร 4 ปี";
                break;
            case 1:
                content = "          หม่อมหลวงปิ่น มาลากุล เกิดเมื่อวันที่ ๒๔ ตุลาคม พ.ศ. ๒๔๔๖ สืบเชื้อสายมาจากต้นราชสกุล มาลากุล ณ อยุธยา คือ สมเด็จเจ้าฟ้ามหามาลา กรมพระยาบำราบปรปักษ์ พระเจ้าลูกยาเธอในพระบาทสมเด็จพระพุทธเลิศหล้านภาลัย อันประสูติแต่เจ้าฟ้ากุณฑลทิพยวดี บิดามารดาของ ม.ล.ปิ่นคือเจ้าพระยาพระเสด็จสุเรนทราธิบดี (หม่อมราชวงศ์เปีย มาลากุล) และท่านผู้หญิงเสงี่ยม (สกุลเดิม วสันตสิงห์) ท่านได้สมรสกับท่านผู้หญิงดุษฎีมาลา มาลากุล ณ อยุธยา (สกุลเดิม ไกรฤกษ์) ไม่มีบุตรธิดา";
                break;
            case 2:
                content = "          หม่อมหลวงปิ่น มาลากุล ได้เขียนบทละครสังคีต เรื่อง “หงส์ทอง” ให้กับวิทยาลัยครูสวนดุสิตโดยเขียนตามเค้าเรื่อง Le Lac des Cygnes ของ Piotor ILich Tchaibowsky หรือ Swan Lake (โดยปีเตอร์อิลิชไชคอฟ สกี นำมาแต่งบัลเล่ต์หรือระบำปลายเท้าขนาดเล็ก Lebedinoje osero ซึ่งมีการแสดงดนตรีประกอบการระบำปลายเท้า มีการจัดแสดงที่โรงละคร Bolshoi กรุงมอสโกและอีกหลายโรงละคร) หม่อมหลวงปิ่น มาลากุล จึงได้นำเค้าเรื่องดังกล่าวมาประยุกต์กับบทละครและให้มีการจัดแสดงครั้งแรกในงานแจกประกาศนียบัตรของนักศึกษาวิทยาลัยครูสวนดุสิต เมื่อวันที่ ๑๐ มีนาคม ปีพุทธศักราช ๒๕๑๐ ในปีต่อมาเมื่อมีผู้นิยมชมละครที่นักศึกษาแสดงมากขึ้น ผู้อำนวยการของวิทยาลัยครูสวนดุสิต ขณะนั้น (คุณหญิงกระจ่างศรี รักตะกนิษฐ) จึงได้คิดที่จะทำให้เกิดประโยชน์กับนักศึกษาที่ขาดแคลนทุนทรัพย์ จึงจัดให้นักศึกษาไปแสดงเรื่อง “หงส์ทอง” ทางวิทยุ โทรทัศน์ มีผู้บริจาคเงินเพื่อตั้งเป็นกองทุนการศึกษา เรียกว่า “ทุนหงส์ทอง” จำนวนมากโดยจัดแสดงในวันที่ ๒๔ ตุลาคม ปีพุทธศักราช ๒๕๑๑ เนื่องในวันคล้ายวันเกิดของ หม่อมหลวงปิ่น มาลากุล และ วิทยาลัยครูสวนดุสิต ถือว่า วันที่ ๒๔ ตุลาคม เป็น “วันหงส์ทอง” มีการมอบทุนการศึกษา และรับเงิน สมทบทุนเพิ่มเติม ในวัน “หงส์ทอง”";
                break;
        }

        TextView contentTextView = view.findViewById(R.id.content_text_view);
        contentTextView.setText(content);

        Button plusButton = view.findViewById(R.id.plus_button);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuDetailsFragment fragment = MenuDetailsFragment.newInstance(mType);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
