package com.example.zututestdemo;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher.OnPhotoTapListener;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private ViewPager viewpager;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

	private void initData() {
		List<String> imgList = new ArrayList<String>();
		imgList.add("http://www.jwb.com.cn/wjnew/st/zutu/201604/P020160408001855126082.jpg");
		imgList.add("http://www.jwb.com.cn/wjnew/st/zutu/201604/P020160408001856374644.jpg");
		imgList.add("http://www.jwb.com.cn/wjnew/st/zutu/201604/P020160408001857151815.jpg");
		imgList.add("http://www.jwb.com.cn/wjnew/st/zutu/201604/P020160408001857930270.jpg");
		imgList.add("http://www.jwb.com.cn/wjnew/st/zutu/201604/P020160408001858710167.jpg");
		imgList.add("http://www.jwb.com.cn/wjnew/st/zutu/201604/W020160408001848234961.jpg");
		List<String> desList = new ArrayList<String>();
		desList.add("夜空");
		desList.add("美丽的夜空，郎朗星空黑色的宇宙。美丽的夜空，郎朗星空黑色的宇宙。美丽的夜空，郎朗星空黑色的宇宙。美丽的夜空，郎朗星空黑色的宇宙。");
		desList.add("漂亮的壁纸");
		desList.add("图片描述一");
		desList.add("图片描述二");
		desList.add("25");
		MyAdapter adpter = new MyAdapter(imgList, desList, MainActivity.this);

		viewpager.setAdapter(adpter);
	}

	private void initView() {
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		
	}
	private class MyAdapter extends PagerAdapter{
		
		List<String> imgs;
		List<String> descs;
		LayoutInflater inflater;
		Context context;
		boolean first = true;
		public MyAdapter(List<String> imgs,List<String> descs,Context context){
			this.imgs = imgs;
			this.descs = descs;
			inflater = LayoutInflater.from(context);
			this.context = context;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imgs.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}
		//TODO 这里返回一个视图实现基本功能
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			
			View root = inflater.inflate(R.layout.itempager, null);
			PhotoView img = (PhotoView) root.findViewById(R.id.imageview);
			final LinearLayout ll_desc = (LinearLayout) root.findViewById(R.id.ll_desc);
			final TextView desc = (TextView) root.findViewById(R.id.tv_desc);
			if (!(imgs.isEmpty() && descs.isEmpty())) {
				UniversalImageLoadTool.disPlay(imgs.get(position), img, context, 0);
				desc.setText(descs.get(position));
				container.addView(root);
				img.setOnPhotoTapListener(new OnPhotoTapListener() {
					
					@Override
					public void onPhotoTap(View view, float x, float y) {
						// TODO Auto-generated method stub
						if (first) {
							first =false;
							ll_desc.setVisibility(View.GONE);
						}else{
							first = true;
							ll_desc.setVisibility(View.VISIBLE);
						}
						
					}
				});
				return root;
				
			}
			
			return null;
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View)object);
		}
	}

   
}
