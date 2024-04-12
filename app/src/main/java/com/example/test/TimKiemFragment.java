package com.example.test;

import static android.R.layout.simple_list_item_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class TimKiemFragment extends Fragment {

    SearchView searchView;
    ListView listview;
    ArrayList<String> trasua = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_tim_kiem, container, false);
        listview = root.findViewById(R.id.lv_trasua);
        addControls();
        return root;
    }

    private void addControls() {
        trasua.addAll(Arrays.asList(getResources().getStringArray(R.array.arrtrasua)));
        arrayAdapter = new ArrayAdapter<>(getActivity(), simple_list_item_1,trasua);
        listview.setAdapter(arrayAdapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //true nếu truy vấn đã được người nghe xử lý, false để cho SearchView thực hiện hành động mặc định.
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            //Tìm kiếm đến đâu thì nó hiển thị ra tới đó
            //true nếu hành động đó được người nghe xử lý.
            @Override
            public boolean onQueryTextChange(String newText) {
                String text = newText;
                arrayAdapter.getFilter().filter(text);

                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}