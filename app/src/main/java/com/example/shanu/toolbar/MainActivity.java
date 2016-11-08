package com.example.shanu.toolbar;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
   private RecyclerView mTittleRecyclerView;
    private DataAdapter adapter = null;
    public static final String TO_DO_ID="unique id for each task";
    private List<TO_DO> mlistData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTittleRecyclerView = (RecyclerView) findViewById(R.id.detail_recycler_view);
        mTittleRecyclerView.setLayoutManager(new LinearLayoutManager(this));

     //   adapter = new DataAdapter(tittle_list, this);
     //   mTittleRecyclerView.setAdapter(adapter);

           updateUI();


    }
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
     //   Toast.makeText(this,"hello", Toast.LENGTH_SHORT).show();
    }
    private void updateUI()
    {
        Data_source data_source=Data_source.get(getApplicationContext());
        List<TO_DO> to_dos = data_source.getTo_do();

        if (adapter == null) {
            adapter = new DataAdapter(to_dos,getApplicationContext());
            mTittleRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else {
            adapter = new DataAdapter(to_dos,getApplicationContext());
            mTittleRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
          //  Toast.makeText(this,"hello//", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      /*  if (id == R.id.action_settings) {
            return true;
        }  */
        if(id==R.id.navigate)
        {
            startActivity(new Intent(this,AddTask.class));
        }

        return super.onOptionsItemSelected(item);
    }
    class DataHolder extends RecyclerView.ViewHolder  implements View.OnClickListener
    {
        private TO_DO current_to_do;

        public TextView mTitleTextView;
        public DataHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView= (TextView) itemView.findViewById(R.id.tv_title_row);
        }

        public void setTodo(TO_DO current)
        {
            current_to_do=current;
            mTitleTextView.setText(current_to_do.getmTitle());
        }

        @Override
        public void onClick(View v) {
            int postion=mTittleRecyclerView.getChildLayoutPosition(v);
        //    String string=mlistData.get(postion).getmTitle();
          //  Toast.makeText(getApplicationContext(),string,Toast.LENGTH_SHORT).show();
             Intent intent=new Intent(getApplicationContext(),ViewPagerActivity.class);
            intent.putExtra(TO_DO_ID,postion);
        //    Toast.makeText(getApplicationContext(),v.getId()+"",Toast.LENGTH_SHORT).show();
           startActivity(intent);

        }
    }
    public class DataAdapter extends RecyclerView.Adapter<DataHolder> {

        private LayoutInflater inflater;
        Context context;
        public DataAdapter(List<TO_DO> listData, Context c){
            inflater = LayoutInflater.from(c);
            mlistData = listData;
            context=c;

        }
        @Override
        public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.list_item, parent, false);
            return new DataHolder(view);
        }

        @Override
        public void onBindViewHolder(DataHolder holder, int position) {
            TO_DO current_to_do = mlistData.get(position);
            holder.setTodo(current_to_do);

        }

        @Override
        public int getItemCount() {
            return mlistData.size();
        }






    }

}
