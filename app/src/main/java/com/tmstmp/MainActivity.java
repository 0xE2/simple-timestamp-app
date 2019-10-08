package com.tmstmp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
//import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.app.Activity;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ScrollView;
import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.content.ClipData;
import android.content.ClipboardManager;

public class MainActivity extends Activity {
	
	
	private ArrayList<String> tstmp = new ArrayList<>();
	
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ListView listview;
	private ScrollView vscroll1;
	private Button button;
	private TextView version_view;
	
	private Calendar calendar = Calendar.getInstance();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		listview = (ListView) findViewById(R.id.listview);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		button = (Button) findViewById(R.id.button);
		version_view = (TextView) findViewById(R.id.version_view);
		
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", tstmp.get((int)(_position))));
			}
		});
		
		listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				tstmp.remove((int)(_position));
				listview.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, tstmp));
				return true;
			}
		});
		
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tstmp.add(String.valueOf((long)(calendar.getTimeInMillis())));
				listview.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, tstmp));
			}
		});
	}
	private void initializeLogic() {
		version_view.setText("v0.01h");
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
