package com.startapp.android.publish.adinformation;

import android.content.Context;
import android.support.v4.media.TransportMediator;
import com.startapp.android.publish.adinformation.AdInformationPositions.Position;
import com.startapp.android.publish.model.AdPreferences.Placement;
import com.startapp.android.publish.p022h.StartAppSDK;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

/* compiled from: StartAppSDK */
public class AdInformationConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private List<StartAppSDK> ImageResources;
    protected HashMap<Placement, Position> Positions;
    private StartAppSDK SimpleToken;
    private transient EnumMap<ImageResourceType, StartAppSDK> f3007a;
    private String dialogUrl;
    private boolean enabled;
    private float fatFingersFactor;

    /* compiled from: StartAppSDK */
    public enum ImageResourceType {
        INFO_S(17, 14),
        INFO_EX_S(88, 14),
        INFO_L(25, 21),
        INFO_EX_L(TransportMediator.KEYCODE_MEDIA_RECORD, 21);
        
        private int height;
        private int width;

        private ImageResourceType(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getDefaultWidth() {
            return this.width;
        }

        public int getDefaultHeight() {
            return this.height;
        }

        public static ImageResourceType getByName(String name) {
            ImageResourceType imageResourceType = INFO_S;
            ImageResourceType[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].name().toLowerCase().compareTo(name.toLowerCase()) == 0) {
                    imageResourceType = values[i];
                }
            }
            return imageResourceType;
        }
    }

    private AdInformationConfig() {
        this.enabled = true;
        this.fatFingersFactor = 200.0f;
        this.dialogUrl = "http://d1byvlfiet2h9q.cloudfront.net/InApp/resources/adInformationDialog3.html";
        this.SimpleToken = new StartAppSDK();
        this.Positions = new HashMap();
        this.f3007a = new EnumMap(ImageResourceType.class);
        this.ImageResources = new ArrayList();
    }

    public static AdInformationConfig m2821a() {
        AdInformationConfig adInformationConfig = new AdInformationConfig();
        m2822a(adInformationConfig);
        return adInformationConfig;
    }

    public static void m2822a(AdInformationConfig adInformationConfig) {
        adInformationConfig.m2834h();
        adInformationConfig.m2833g();
    }

    public boolean m2828b() {
        return this.enabled;
    }

    public boolean m2827a(Context context) {
        return !StartAppSDK.m3207a(context, "userDisabledAdInformation", Boolean.valueOf(false)).booleanValue() && m2828b();
    }

    public void m2825a(Context context, boolean z) {
        StartAppSDK.m3212b(context, "userDisabledAdInformation", Boolean.valueOf(!z));
    }

    public float m2829c() {
        return this.fatFingersFactor / 100.0f;
    }

    protected void m2826a(ImageResourceType imageResourceType, StartAppSDK startAppSDK) {
        this.f3007a.put(imageResourceType, startAppSDK);
    }

    public String m2830d() {
        return this.dialogUrl;
    }

    public StartAppSDK m2831e() {
        return this.SimpleToken;
    }

    public Position m2823a(Placement placement) {
        Position position = (Position) this.Positions.get(placement);
        if (position != null) {
            return position;
        }
        position = Position.BOTTOM_LEFT;
        this.Positions.put(placement, position);
        return position;
    }

    public StartAppSDK m2824a(ImageResourceType imageResourceType) {
        return (StartAppSDK) this.f3007a.get(imageResourceType);
    }

    public void m2832f() {
        for (StartAppSDK startAppSDK : this.ImageResources) {
            m2826a(ImageResourceType.getByName(startAppSDK.m2875a()), startAppSDK);
            startAppSDK.m2884d();
        }
    }

    protected void m2833g() {
        for (Object obj : ImageResourceType.values()) {
            if (this.f3007a.get(obj) == null) {
                throw new IllegalArgumentException("AdInformation error in ImageResource [" + obj + "] cannot be found in MetaData");
            }
        }
    }

    protected void m2834h() {
        for (Enum enumR : ImageResourceType.values()) {
            StartAppSDK startAppSDK = (StartAppSDK) this.f3007a.get(enumR);
            Boolean valueOf = Boolean.valueOf(true);
            if (startAppSDK == null) {
                Boolean valueOf2;
                StartAppSDK c = StartAppSDK.m2873c(enumR.name());
                for (StartAppSDK startAppSDK2 : this.ImageResources) {
                    if (ImageResourceType.getByName(startAppSDK2.m2875a()).equals(enumR)) {
                        valueOf2 = Boolean.valueOf(false);
                        break;
                    }
                }
                valueOf2 = valueOf;
                this.f3007a.put(enumR, c);
                if (valueOf2.booleanValue()) {
                    this.ImageResources.add(c);
                }
                startAppSDK2 = c;
            }
            startAppSDK2.m2876a(enumR.getDefaultWidth());
            startAppSDK2.m2881b(enumR.getDefaultHeight());
            startAppSDK2.m2878a(enumR.name().toLowerCase() + ".png");
        }
    }
}
