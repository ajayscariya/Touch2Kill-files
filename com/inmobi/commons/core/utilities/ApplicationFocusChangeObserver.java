package com.inmobi.commons.core.utilities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.inmobi.commons.core.utilities.a */
public class ApplicationFocusChangeObserver {
    private static final String f1636a;
    private static List<ApplicationFocusChangeObserver> f1637b;
    private static HandlerThread f1638c;
    private static Application f1639d;
    private static final Object f1640e;
    private static volatile ApplicationFocusChangeObserver f1641f;

    /* renamed from: com.inmobi.commons.core.utilities.a.1 */
    class ApplicationFocusChangeObserver implements InvocationHandler {
        final /* synthetic */ ApplicationFocusChangeObserver f1627a;
        private final Handler f1628b;

        ApplicationFocusChangeObserver(ApplicationFocusChangeObserver applicationFocusChangeObserver) {
            this.f1627a = applicationFocusChangeObserver;
            this.f1628b = new ApplicationFocusChangeObserver(ApplicationFocusChangeObserver.f1638c.getLooper());
        }

        public void m1746a(Activity activity) {
            this.f1628b.sendEmptyMessageDelayed(1001, 3000);
        }

        public void m1747b(Activity activity) {
            this.f1628b.removeMessages(1001);
            this.f1628b.sendEmptyMessage(1002);
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (objArr != null) {
                if (method.getName().equals("onActivityPaused")) {
                    m1746a((Activity) objArr[0]);
                } else if (method.getName().equals("onActivityResumed")) {
                    m1747b((Activity) objArr[0]);
                }
            }
            return null;
        }
    }

    /* renamed from: com.inmobi.commons.core.utilities.a.a */
    static class ApplicationFocusChangeObserver extends Handler {
        boolean f1629a;

        public ApplicationFocusChangeObserver(Looper looper) {
            super(looper);
            this.f1629a = true;
        }

        public void handleMessage(Message message) {
            if (message.what == 1001 && this.f1629a) {
                this.f1629a = false;
                ApplicationFocusChangeObserver.m1769b(Boolean.valueOf(false));
                Logger.m1744a(InternalLogLevel.INTERNAL, ApplicationFocusChangeObserver.f1636a, "App has gone to background.");
            } else if (message.what == 1002 && !this.f1629a) {
                this.f1629a = true;
                ApplicationFocusChangeObserver.m1769b(Boolean.valueOf(true));
                Logger.m1744a(InternalLogLevel.INTERNAL, ApplicationFocusChangeObserver.f1636a, "App has come to foreground.");
            }
        }
    }

    /* renamed from: com.inmobi.commons.core.utilities.a.b */
    public interface ApplicationFocusChangeObserver {
        void m1748a(boolean z);
    }

    static {
        f1636a = ApplicationFocusChangeObserver.class.getSimpleName();
        f1637b = new ArrayList();
        f1638c = null;
        f1640e = new Object();
    }

    public static ApplicationFocusChangeObserver m1766a() {
        ApplicationFocusChangeObserver applicationFocusChangeObserver = f1641f;
        if (applicationFocusChangeObserver == null) {
            synchronized (f1640e) {
                applicationFocusChangeObserver = f1641f;
                if (applicationFocusChangeObserver == null) {
                    applicationFocusChangeObserver = new ApplicationFocusChangeObserver();
                    f1641f = applicationFocusChangeObserver;
                }
            }
        }
        return applicationFocusChangeObserver;
    }

    private ApplicationFocusChangeObserver() {
        f1639d = (Application) SdkContext.m1562b();
    }

    @TargetApi(14)
    private void m1771d() {
        String str = "registerActivityLifecycleCallbacks";
        str = "ActivityLifecycleCallbacks";
        str = "onActivityPaused";
        str = "onActivityResumed";
        f1638c = new HandlerThread("ApplicationFocusChangeObserverHandler");
        f1638c.start();
        Class[] declaredClasses = Application.class.getDeclaredClasses();
        Class cls = null;
        int length = declaredClasses.length;
        int i = 0;
        while (i < length) {
            Class cls2 = declaredClasses[i];
            if (cls2.getSimpleName().equalsIgnoreCase("ActivityLifecycleCallbacks")) {
                new Class[1][0] = cls2;
            } else {
                cls2 = cls;
            }
            i++;
            cls = cls2;
        }
        if (Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new ApplicationFocusChangeObserver(this)) != null) {
            try {
                Application.class.getMethod("registerActivityLifecycleCallbacks", new Class[]{cls}).invoke(f1639d, new Object[]{r0});
            } catch (Throwable e) {
                Logger.m1745a(InternalLogLevel.INTERNAL, f1636a, "Error while registering activity life cycle listener.", e);
            } catch (Throwable e2) {
                Logger.m1745a(InternalLogLevel.INTERNAL, f1636a, "Error while registering activity life cycle listener.", e2);
            } catch (Throwable e22) {
                Logger.m1745a(InternalLogLevel.INTERNAL, f1636a, "Error while registering activity life cycle listener.", e22);
            }
        }
    }

    public void m1772a(ApplicationFocusChangeObserver applicationFocusChangeObserver) {
        if (VERSION.SDK_INT >= 14) {
            f1637b.add(applicationFocusChangeObserver);
            if (f1637b.size() == 1) {
                m1771d();
            }
        }
    }

    private static void m1769b(Boolean bool) {
        for (ApplicationFocusChangeObserver a : f1637b) {
            a.m1748a(bool.booleanValue());
        }
    }
}
