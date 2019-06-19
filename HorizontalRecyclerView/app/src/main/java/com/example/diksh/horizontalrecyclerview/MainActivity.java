package com.example.diksh.horizontalrecyclerview;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ListItemClicked{
public static final String TAG="mainactivity";

    Button fragmentbtn;

    List<verticalpojo> vp;
    List<horizontalpojo>hp;

    ArrayList<horizontalpojo>list1=new ArrayList<>();
    ArrayList<horizontalpojo>list2=new ArrayList<>();
    ArrayList<horizontalpojo>list3=new ArrayList<>();
    ArrayList<horizontalpojo>list4=new ArrayList<>();
    ArrayList<horizontalpojo>list5=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        getImages();



    }
   /* private void getCircularimages(){


        circularImages.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        circularImages.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        circularImages.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        circularImages.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        circularImages.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        circularImages.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        circularImages.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        circularImages.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        circularImages.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        circularImages.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        circularImages.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        circularImages.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");

        hp=new ArrayList<>();

      hp.add(new horizontalpojo(R.drawable.looks));
        hp.add(new horizontalpojo(R.drawable.lips));
        hp.add(new horizontalpojo(R.drawable.eye));
        hp.add(new horizontalpojo(R.drawable.hair));
        hp.add(new horizontalpojo(R.drawable.nails));

        initRecyclerView2();
    }*/
    private void initRecyclerView2(){


        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.circularRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        circleRecyclerView adapter = new circleRecyclerView(getBaseContext(),hp);
        recyclerView.setAdapter(adapter);
    }
    private void getImages(){

        vp=new ArrayList<>();

        vp.add(new verticalpojo(R.drawable.looks,"Looks",list1));
        vp.add(new verticalpojo(R.drawable.lips,"Lips",list2));
        vp.add(new verticalpojo(R.drawable.eye,"Face",list3));
        vp.add(new verticalpojo(R.drawable.hair,"Hair",list4));
        vp.add(new verticalpojo(R.drawable.nails,"Nails",list5));

      /*  mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");*/

        initRecyclerView();

    }
    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getBaseContext(),vp,this);
        recyclerView.setAdapter(adapter);
    }
  /*  @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(CustomMessageEvent event) {
        //Log.e("Event is created","yes");

        Toast.makeText(this, "hgjgjg", Toast.LENGTH_SHORT).show();


            }



           */ @Override
    public void  onListItemClicked(int itemClickedPos){
        if(itemClickedPos == 0){
            hp=new ArrayList<>();
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
            hp.add(new horizontalpojo(R.drawable.looks));
            initRecyclerView2();


        }
        if(itemClickedPos == 1){
            hp=new ArrayList<>();
            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
            hp.add(new horizontalpojo(R.drawable.lips));
            initRecyclerView2();
        }
      if(itemClickedPos == 2){
          hp=new ArrayList<>();
          Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
          hp.add(new horizontalpojo(R.drawable.eye));
          initRecyclerView2();
      }
      if(itemClickedPos == 3){
          hp=new ArrayList<>();
          Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
          hp.add(new horizontalpojo(R.drawable.hair));
          initRecyclerView2();
      }
      if(itemClickedPos == 4){
          hp=new ArrayList<>();
          Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
          hp.add(new horizontalpojo(R.drawable.nails));
          initRecyclerView2();
      }
    }


}
