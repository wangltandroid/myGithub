package com.example.zututestdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

/**
 * ImageLoader加载类
 */
public class UniversalImageLoadTool {

    private static ImageLoader imageLoader = ImageLoader.getInstance();

    public static ImageLoader getImageLoader() {
        return imageLoader;
    }

    public static boolean checkImageLoader() {
        return imageLoader.isInited();
    }

    /**
     * 使用ImageAware加载，并带默认图片（可加载本地相册）
     */
    public static void disPlay(String uri, ImageAware imageAware,
                               int default_pic, Context context) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(default_pic)
                .showImageForEmptyUri(default_pic).showImageOnFail(default_pic)
                .cacheInMemory(true).cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new SimpleBitmapDisplayer()).build();
        // 配置configuration
        CheckImageLoaderConfiguration.checkImageLoaderConfiguration(context,
                imageLoader);
        imageLoader.displayImage(uri, imageAware, options);
    }

   
    /**
     * 带默认图片加载
     */
    public static void disPlay(String uri, ImageView imageview, Context context, int resource) {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(resource)
                .showImageForEmptyUri(resource)
                .showImageOnFail(resource).cacheInMemory(true)
                .cacheOnDisk(true).bitmapConfig(Bitmap.Config.RGB_565)

                .displayer(new SimpleBitmapDisplayer()).build();
        // 配置configuration
        CheckImageLoaderConfiguration.checkImageLoaderConfiguration(context,
                imageLoader);
        imageLoader.displayImage(uri, imageview, options);
    }

    /**
     * 加载圆角图片
     */
    public static void disRoundedPlay(String uri, ImageView imageview,
                                      int default_pic, Context context) {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(default_pic)
                .showImageForEmptyUri(default_pic).showImageOnFail(default_pic)
                .cacheInMemory(true).cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new RoundedBitmapDisplayer(15)).build();
        // 配置configuration
        CheckImageLoaderConfiguration.checkImageLoaderConfiguration(context,
                imageLoader);
        imageLoader.displayImage(uri, imageview, options);
    }

   

    public static void clear() {
        imageLoader.clearMemoryCache();
        imageLoader.clearDiskCache();
    }

    public static void resume() {
        imageLoader.resume();
    }

    /**
     * 暂停加载
     */
    public static void pause() {
        imageLoader.pause();
    }

    /**
     * 停止加载
     */
    public static void stop() {
        imageLoader.stop();
    }

    /**
     * 销毁加载
     */
    public static void destroy() {
        imageLoader.destroy();
    }
}
