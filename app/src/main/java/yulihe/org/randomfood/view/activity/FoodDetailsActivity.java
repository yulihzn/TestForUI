package yulihe.org.randomfood.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.eftimoff.androipathview.PathView;
import com.kogitune.activity_transition.ActivityTransition;

import yulihe.org.randomfood.R;
import yulihe.org.randomfood.base.BaseActivity;
import yulihe.org.randomfood.bean.FoodBean;
import yulihe.org.randomfood.presenter.FoodCardDetailsPresenter;
import yulihe.org.randomfood.utils.ImageUtils;
import yulihe.org.randomfood.view.viewinterface.FoodCardDetailsView;

public class FoodDetailsActivity extends BaseActivity<FoodCardDetailsView,FoodCardDetailsPresenter> {
    private ImageView iv_head;

    private Button bt_save;
    public static final int TEXT = 0;
    public static final int EDIT = 1;
    private int[]mode={TEXT,TEXT,TEXT};
    private ImageButton[] ib_modify = new ImageButton[3];
    private EditText[] et_content = new EditText[3];
    private FoodBean foodBean;

    private PathView pv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTransition.with(getIntent()).to(findViewById(R.id.iv_head)).start(savedInstanceState);
    }

    @Override
    protected void initViews() {
        presenter.setFoodCardBean((FoodBean) getIntent().getSerializableExtra("data"));
        foodBean = presenter.getFoodCardBean();
        iv_head = (ImageView) findViewById(R.id.iv_head);
        ImageUtils.loadImage(this,foodBean.getImageUrl(),iv_head);
        iv_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String[]arr = {foodBean.getName(),foodBean.getDescription(),foodBean.getPrice()};
        int[]ibRes = {R.id.ib_modify_name,R.id.ib_modify_desc,R.id.ib_modify_price};
        int[]etRes = {R.id.et_name,R.id.et_desc,R.id.et_price};
        for (int i = 0; i < ibRes.length ; i++) {
            ib_modify[i] = (ImageButton) findViewById(ibRes[i]);
            et_content[i] = (EditText) findViewById(etRes[i]);
            ib_modify[i].setOnClickListener(this);
            et_content[i].setText(arr[i]);
        }
        bt_save = (Button) findViewById(R.id.bt_save);
        bt_save.setOnClickListener(this);
        resetMode();
        pv = (PathView) findViewById(R.id.pv);
        pv.setOnClickListener(this);

    }

    @Override
    protected FoodCardDetailsPresenter createPresenter() {
        return new FoodCardDetailsPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_food_details;
    }

    @Override
    protected void initToolBar() {

    }

    private void changeMode(int index){
        if(index >= mode.length){
            return;
        }
        if(mode[index]==EDIT){
            mode[index]=TEXT;
            ib_modify[index].setImageResource(R.drawable.ic_modify);
            et_content[index].setEnabled(false);
            et_content[index].setFocusable(false);
            if(foodBean != null){
                String[]arr = {foodBean.getName(),foodBean.getDescription(),foodBean.getPrice()};
                et_content[index].setText(arr[index]);
            }
        }else{
            mode[index]=EDIT;
            ib_modify[index].setImageResource(R.drawable.ic_close);
            et_content[index].setEnabled(true);
            et_content[index].setSelection(et_content[index].getText().length());
            et_content[index].setFocusable(true);
        }
        bt_save.setVisibility(View.INVISIBLE);
        for (int i = 0; i < mode.length; i++) {
            if(mode[i] == EDIT){
                bt_save.setVisibility(View.VISIBLE);
            }
        }
    }
    private void resetMode(){
        String[]arr = {foodBean.getName(),foodBean.getDescription(),foodBean.getPrice()};
        for (int i = 0; i < mode.length; i++) {
            mode[i] = TEXT;
            et_content[i].setText(arr[i]);
            ib_modify[i].setImageResource(R.drawable.ic_modify);
            et_content[i].setEnabled(false);
            bt_save.setVisibility(View.INVISIBLE);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_modify_name:
                changeMode(0);
                break;
            case R.id.ib_modify_desc:
                changeMode(1);
                break;
            case R.id.ib_modify_price:
                changeMode(2);
                break;
            case R.id.bt_save:
                saveData();
                break;
            case R.id.pv:

                break;
            default:break;
        }
    }

    private void saveData() {
        foodBean.setName(et_content[0].getText().toString());
        foodBean.setDescription(et_content[1].getText().toString());
        foodBean.setPrice(et_content[2].getText().toString());
        resetMode();
    }
}
