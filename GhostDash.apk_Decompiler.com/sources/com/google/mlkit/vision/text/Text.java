package com.google.mlkit.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.mlkit_vision_text.zzbs;
import com.google.android.gms.internal.mlkit_vision_text.zzlq;
import com.google.android.gms.internal.mlkit_vision_text.zzls;
import com.google.android.gms.internal.mlkit_vision_text.zzlu;
import com.google.android.gms.internal.mlkit_vision_text.zzlw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public class Text {
    private final List<TextBlock> zza;
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
    static class TextBase {
        private final String zza;
        private final Rect zzb;
        private final Point[] zzc;
        private final String zzd;

        TextBase(String str, Rect rect, List<Point> list, String str2) {
            this.zza = str;
            this.zzb = rect;
            this.zzc = (Point[]) list.toArray(new Point[0]);
            this.zzd = str2;
        }

        public Rect getBoundingBox() {
            return this.zzb;
        }

        public Point[] getCornerPoints() {
            return this.zzc;
        }

        public String getRecognizedLanguage() {
            return this.zzd;
        }

        /* access modifiers changed from: protected */
        public final String zza() {
            String str = this.zza;
            return str == null ? "" : str;
        }
    }

    public Text(zzlw zzlw) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        this.zzb = zzlw.zza();
        arrayList.addAll(zzbs.zza(zzlw.zzb(), zza.zza));
    }

    public String getText() {
        return this.zzb;
    }

    public List<TextBlock> getTextBlocks() {
        return Collections.unmodifiableList(this.zza);
    }

    public Text(String str, List<TextBlock> list) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        arrayList.addAll(list);
        this.zzb = str;
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
    public static class Element extends TextBase {
        Element(zzls zzls) {
            super(zzls.zzc(), zzls.zza(), zzls.zzd(), zzls.zzb());
        }

        public String getText() {
            return zza();
        }

        public Element(String str, Rect rect, List<Point> list, String str2) {
            super(str, rect, list, str2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
    public static class Line extends TextBase {
        private final List<Element> zza;

        Line(zzlu zzlu) {
            super(zzlu.zzc(), zzlu.zza(), zzlu.zzd(), zzlu.zzb());
            this.zza = zzbs.zza(zzlu.zze(), zzb.zza);
        }

        public synchronized List<Element> getElements() {
            return this.zza;
        }

        public String getText() {
            return zza();
        }

        public Line(String str, Rect rect, List<Point> list, String str2, List<Element> list2) {
            super(str, rect, list, str2);
            this.zza = list2;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
    public static class TextBlock extends TextBase {
        private final List<Line> zza;

        TextBlock(zzlq zzlq) {
            super(zzlq.zzc(), zzlq.zza(), zzlq.zzd(), zzlq.zzb());
            this.zza = zzbs.zza(zzlq.zze(), zzc.zza);
        }

        public synchronized List<Line> getLines() {
            return this.zza;
        }

        public String getText() {
            return zza();
        }

        public TextBlock(String str, Rect rect, List<Point> list, String str2, List<Line> list2) {
            super(str, rect, list, str2);
            this.zza = list2;
        }
    }
}
