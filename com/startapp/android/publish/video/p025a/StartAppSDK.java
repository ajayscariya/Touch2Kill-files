package com.startapp.android.publish.video.p025a;

import com.startapp.android.publish.video.tracking.VideoTrackingLink;
import com.startapp.android.publish.video.tracking.VideoTrackingLink.TrackingSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import mf.javax.xml.XMLConstants;

/* renamed from: com.startapp.android.publish.video.a.b */
public class StartAppSDK {
    private VideoTrackingLink[] f3633a;
    private com.startapp.android.publish.video.tracking.StartAppSDK f3634b;
    private String f3635c;
    private int f3636d;
    private String f3637e;
    private StartAppSDK f3638f;

    /* renamed from: com.startapp.android.publish.video.a.b.a */
    public enum StartAppSDK {
        GENERAL(Integer.valueOf(400)),
        FILE_DOWNLOAD(Integer.valueOf(401));
        
        Integer code;

        private StartAppSDK(Integer num) {
            this.code = num;
        }

        public String toString() {
            return this.code.toString();
        }
    }

    public StartAppSDK(VideoTrackingLink[] videoTrackingLinkArr, com.startapp.android.publish.video.tracking.StartAppSDK startAppSDK, String str, int i) {
        this.f3637e = XMLConstants.NULL_NS_URI;
        this.f3633a = videoTrackingLinkArr;
        this.f3634b = startAppSDK;
        this.f3635c = str;
        this.f3636d = i;
    }

    public StartAppSDK m3904a(StartAppSDK startAppSDK) {
        this.f3638f = startAppSDK;
        return this;
    }

    public StartAppSDK m3905a(String str) {
        this.f3637e = str;
        return this;
    }

    public StartAppSDK m3903a() {
        if (m3900b()) {
            List arrayList = new ArrayList();
            for (VideoTrackingLink videoTrackingLink : this.f3633a) {
                if (videoTrackingLink.m3942b() == null) {
                    com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoEventBuilder", 5, "Ignoring tracking link - tracking url is null: tracking link = " + videoTrackingLink);
                } else if (this.f3634b.m3265a() <= 0 || videoTrackingLink.m3943c()) {
                    arrayList.add(m3897a(videoTrackingLink));
                } else {
                    com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoEventBuilder", 3, "Ignoring tracking link - external replay event: tracking link = " + videoTrackingLink);
                }
            }
            return new StartAppSDK(arrayList, this.f3637e);
        }
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoEventBuilder", 3, "Some fields have illegal values");
        return null;
    }

    private boolean m3900b() {
        return (this.f3633a == null || this.f3634b == null) ? false : true;
    }

    private String m3897a(VideoTrackingLink videoTrackingLink) {
        StringBuilder stringBuilder = new StringBuilder();
        com.startapp.android.publish.video.tracking.StartAppSDK b = m3898b(videoTrackingLink);
        String b2 = videoTrackingLink.m3942b();
        stringBuilder.append(m3899b(b2)).append(b.m5632c());
        if (b.m5635f()) {
            stringBuilder.append(com.startapp.android.publish.p022h.StartAppSDK.m3193a(com.startapp.android.publish.p022h.StartAppSDK.m3331b(b2)));
        }
        return stringBuilder.toString();
    }

    private com.startapp.android.publish.video.tracking.StartAppSDK m3898b(VideoTrackingLink videoTrackingLink) {
        TrackingSource e = videoTrackingLink.m3945e();
        com.startapp.android.publish.video.tracking.StartAppSDK startAppSDK = this.f3634b;
        boolean z = e != null && e == TrackingSource.STARTAPP;
        return startAppSDK.m5630b(z).m5628a(videoTrackingLink.m3943c()).m5629b(videoTrackingLink.m3944d());
    }

    private String m3899b(String str) {
        String replace = str.replace("[ASSETURI]", this.f3635c).replace("[CONTENTPLAYHEAD]", m3902d()).replace("[CACHEBUSTING]", m3901c());
        return this.f3638f != null ? replace.replace("[ERRORCODE]", this.f3638f.toString()) : replace;
    }

    private String m3901c() {
        return new Integer(10000000 + new Random().nextInt(90000000)).toString();
    }

    private String m3902d() {
        long convert = TimeUnit.SECONDS.convert((long) this.f3636d, TimeUnit.MILLISECONDS);
        long j = convert % 60;
        long j2 = convert / 3600;
        convert = (convert % 3600) / 60;
        long j3 = (long) (this.f3636d % 1000);
        return String.format("%02d:%02d:%02d.%03d", new Object[]{Long.valueOf(j2), Long.valueOf(convert), Long.valueOf(j), Long.valueOf(j3)});
    }
}
