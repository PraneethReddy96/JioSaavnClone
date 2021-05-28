package com.example.saavn_app_praneeth;

import android.graphics.Color;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelectLanguagesAdapter extends RecyclerView.Adapter<SelectLanguagesAdapter.ViewHolder> {
//initialize variable;
    SelectionActivity selectionActivity;
    ArrayList<String> arrayList;
    LanguagesViewModel languagesViewModel;
    boolean isEnabled = false;
    boolean isSelectAll = false;
    ArrayList<String> selectList = new ArrayList<>();

// create constructor
    public SelectLanguagesAdapter(SelectionActivity selectionActivity, ArrayList<String> arrayList) {
        this.selectionActivity = selectionActivity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
// init views
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_mainactivity,parent,false);
// init ViewModel
        languagesViewModel = ViewModelProviders.of((FragmentActivity) selectionActivity)
                .get(LanguagesViewModel.class);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectLanguagesAdapter.ViewHolder holder, int position) {
//set Text on text view
        holder.mTvLanguage.setText(arrayList.get(position));

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // checking condition
                if (!isEnabled){
                    // when action mode is not enable init action mode
                    ActionMode.Callback callback = new ActionMode.Callback() {
                        @Override
                        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                            //Init menu inflater
                            MenuInflater menuInflater = mode.getMenuInflater();
                            //Inflate menu
                            menuInflater.inflate(R.menu.menu,menu);
                            return true;
                        }

                        @Override
                        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                            // when action mode is prepare
                            //set isEnable true
                            isEnabled = true;
                            // create method
                            ClickItem(holder);
                            return false;
                        }

                        @Override
                        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                            // when click on action mode item
                            // get item id
                            int id = item.getItemId();
                            switch (id){
                                case R.id.menu_selectedAll:
                                    // when click select all check condition
                                    if (selectList.size() == arrayList.size()){
                                        // when all item selected set isSelectAll faluse
                                        isSelectAll = false;
                                        //clear select array list
                                        selectList.clear();
                                    }else {
                                        // when all item is unselected set isSelected true
                                        isSelectAll = true;
                                        // clear select array list
                                        selectList.clear();
                                        //add all  value in select array list
                                        selectList.addAll(arrayList);
                                    }
                                    languagesViewModel.setText(String.valueOf(selectList.size()));
                                    // notify adapter
                                    notifyDataSetChanged();
                            }
// return true
                            return true;
                        }

                        @Override
                        public void onDestroyActionMode(ActionMode mode) {
                            // when action mode is destroy set isEnable false
                            isEnabled = false;
                            // set isSelectall false;
                            isSelectAll = false;
                            // clear select ayyay list
                            selectList.clear();
                            // notify adapter
                            notifyDataSetChanged();
                        }
                    };
                    // start action mode
                    ((AppCompatActivity) v.getContext()).startActionMode(callback);
                }else {
                    // when action mode is already enable call method
                    ClickItem(holder);
                }
                //return true
                return true;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check condition
                if (isEnabled){
                    // when action mode is enable call method
                    ClickItem(holder);
                }else {
                    // when action mode is already enable call method display toast
                    Toast.makeText(selectionActivity,"You selected " + arrayList.get(holder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                }
            }
        });
       if (isSelectAll){
           // when all value selectd visible all check box image
           holder.mIvCheckBox.setVisibility(View.VISIBLE);
           //set bg color
           holder.itemView.setBackgroundColor(Color.LTGRAY);
       }else {
           // when all value unselected and hide all check box image
           holder.mIvCheckBox.setBackgroundColor(Color.TRANSPARENT);
       }
    }

    private void ClickItem(ViewHolder holder) {
        //get selected item value
        String s = arrayList.get(holder.getAdapterPosition());
        // check condition
        if (holder.mIvCheckBox.getVisibility() == View.GONE){
            // when item now selected
            // visible checkbox image
            holder.mIvCheckBox.setVisibility(View.VISIBLE);
            // set background color
            holder.itemView.setBackgroundColor(Color.LTGRAY);
            // Add value in select array list
            selectList.add(s);
        }else {
            // when item selected
            // hide check box image
            holder.mIvCheckBox.setVisibility(View.GONE);
            //Set background color
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

//...............view hodlder
    public class ViewHolder extends RecyclerView.ViewHolder {
//Initialize variable
        TextView mTvLanguage;
        CheckBox mIvCheckBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //assign variable
            mTvLanguage = itemView.findViewById(R.id.tvLanguage);
            mIvCheckBox = itemView.findViewById(R.id.iv_checkBox);
        }
    }
}
