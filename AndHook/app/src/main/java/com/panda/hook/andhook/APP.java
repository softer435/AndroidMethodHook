package com.panda.hook.andhook;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;

import com.android.dx.command.Main;
import com.panda.hook.javahook.BackMethod;
import com.panda.hook.javahook.HookManager;
import com.panda.hook.javahook.HookUtil;
import com.panda.hook.javahook.MethodCallback;
import com.panda.hook.javahook.MethodHookParam;

import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by panda on 17/8/19.
 */

public class APP extends Application {

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        try {
             new MainActivity().test1(this,333,4444,'E');
            HookManager.findAndHookMethod(MainActivity.class, "test", Object.class, int.class, int.class, char.class, new MethodCallback() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    Log.i("panda", "i'm in method " +param.method.getName()+" beforeHookedMethod");
//                    param.setResult(111.0);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Log.i("panda", "i'm in method " +param.method.getName()+" afterHookedMethod");
//                    param.setResult(112233.0);
                }
            });
//            Class<?> posixClass =ClassLoader.getSystemClassLoader().loadClass("libcore.io.Posix");
//            HookManager.findAndHookMethod(posixClass, "readBytes", FileDescriptor.class, Object.class, int.class, int.class, new MethodCallback() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    super.beforeHookedMethod(param);
//                    Log.i("panda", "i'm in method " +param.method.getName()+" beforeHookedMethod");
////                    param.setResult(111.0);
//                }
//            });
            HookManager.findAndHookMethod(MainActivity.class, "test1", Object.class, int.class, int.class, char.class, new MethodCallback() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
//                    Log.d("panda", "i'm in method beforeHookedMethod"+());
                    Log.i("panda", "i'm in method beforeHookedMethod "+ param.thisObject);
//                    Log.i("panda", "i'm in method " +param.method.getName()+" beforeHookedMethod");
//                    param.setResult(111.0);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Log.i("panda", "i'm in method " +param.method.getName()+" afterHookedMethod");
//                    param.setResult(112233.0);
                }
            });
            HookManager.findAndHookMethod(MainActivity.class, "test2", new MethodCallback() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
//                    Log.d("panda", "i'm in method beforeHookedMethod"+());
                    Log.i("panda", "i'm in method beforeHookedMethod "+ param.thisObject);
//                    Log.d("panda", "i'm in method " +param.method.getName()+" beforeHookedMethod");
//                    param.setResult(111.0);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Log.i("panda", "i'm in method " +param.method.getName()+" afterHookedMethod");
//                    param.setResult(112233.0);
                }
            });
//            Class;
//            HookManager.findAndHookMethod(Activity.class, "onCreate", Bundle.class, new MethodCallback() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    super.beforeHookedMethod(param);
//                    Log.i("panda", "onCreate:"+param.thisObject.getClass().getName());
//                }
//
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    super.afterHookedMethod(param);
//                    Log.i("panda", "i'm in method " +param.method.getName()+" afterHookedMethod");
//                }
//            });
            HookManager.findAndHookConstructor(Test.class, int.class, int.class, new MethodCallback() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    Log.d("panda", "i'm in method ");
                    //Log.d("panda", "i'm in method " +param.method.getName()+" beforeHookedMethod");
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    //Log.d("panda", "i'm in method " +param.method.getName()+" afterHookedMethod");
                }
            });
            HookManager.startHooks(this);
        }catch (Exception e){
            Log.d("panda","",e);
        }
    }
    public void onCreate() {
        super.onCreate();
    }
}
