package com.example.zututestdemo;

import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.LimitedAgeDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;

/**
 * IMageLoader的config的配置（一般情况写与Application中即可）
 */
public class CheckImageLoaderConfiguration {

    private static final long discCacheLimitTime = 3600 * 24 * 15L;

    public static void checkImageLoaderConfiguration(Context context,
                                                     ImageLoader imageLoader) {
        if (!UniversalImageLoadTool.checkImageLoader()) {
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                    context)
                    .memoryCacheExtraOptions(480, 800)
                    .threadPriority(Thread.NORM_PRIORITY)
                    .denyCacheImageMultipleSizesInMemory()
                    .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                    .memoryCacheSize(2 * 1024 * 1024)
                    .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                    .diskCache(
                            new LimitedAgeDiscCache(StorageUtils
                                    .getCacheDirectory(context),
                                    discCacheLimitTime))
                    .tasksProcessingOrder(QueueProcessingType.LIFO).build();
            imageLoader.init(config);
        }
    }
}
