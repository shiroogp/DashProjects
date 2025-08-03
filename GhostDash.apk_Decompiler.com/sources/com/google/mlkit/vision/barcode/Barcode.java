package com.google.mlkit.vision.barcode;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.vision.barcode.internal.zzk;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public class Barcode {
    public static final int FORMAT_ALL_FORMATS = 0;
    public static final int FORMAT_AZTEC = 4096;
    public static final int FORMAT_CODABAR = 8;
    public static final int FORMAT_CODE_128 = 1;
    public static final int FORMAT_CODE_39 = 2;
    public static final int FORMAT_CODE_93 = 4;
    public static final int FORMAT_DATA_MATRIX = 16;
    public static final int FORMAT_EAN_13 = 32;
    public static final int FORMAT_EAN_8 = 64;
    public static final int FORMAT_ITF = 128;
    public static final int FORMAT_PDF417 = 2048;
    public static final int FORMAT_QR_CODE = 256;
    public static final int FORMAT_UNKNOWN = -1;
    public static final int FORMAT_UPC_A = 512;
    public static final int FORMAT_UPC_E = 1024;
    public static final int TYPE_CALENDAR_EVENT = 11;
    public static final int TYPE_CONTACT_INFO = 1;
    public static final int TYPE_DRIVER_LICENSE = 12;
    public static final int TYPE_EMAIL = 2;
    public static final int TYPE_GEO = 10;
    public static final int TYPE_ISBN = 3;
    public static final int TYPE_PHONE = 4;
    public static final int TYPE_PRODUCT = 5;
    public static final int TYPE_SMS = 6;
    public static final int TYPE_TEXT = 7;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_URL = 8;
    public static final int TYPE_WIFI = 9;
    private final zzk zza;

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public static class Address {
        public static final int TYPE_HOME = 2;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WORK = 1;
        private final int zza;
        private final String[] zzb;

        @Retention(RetentionPolicy.CLASS)
        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
        public @interface AddressType {
        }

        public Address(int i, String[] strArr) {
            this.zza = i;
            this.zzb = strArr;
        }

        public String[] getAddressLines() {
            return this.zzb;
        }

        public int getType() {
            return this.zza;
        }
    }

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public @interface BarcodeFormat {
    }

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public @interface BarcodeValueType {
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public static class CalendarDateTime {
        private final int zza;
        private final int zzb;
        private final int zzc;
        private final int zzd;
        private final int zze;
        private final int zzf;
        private final boolean zzg;
        private final String zzh;

        public CalendarDateTime(int i, int i2, int i3, int i4, int i5, int i6, boolean z, String str) {
            this.zza = i;
            this.zzb = i2;
            this.zzc = i3;
            this.zzd = i4;
            this.zze = i5;
            this.zzf = i6;
            this.zzg = z;
            this.zzh = str;
        }

        public int getDay() {
            return this.zzc;
        }

        public int getHours() {
            return this.zzd;
        }

        public int getMinutes() {
            return this.zze;
        }

        public int getMonth() {
            return this.zzb;
        }

        public String getRawValue() {
            return this.zzh;
        }

        public int getSeconds() {
            return this.zzf;
        }

        public int getYear() {
            return this.zza;
        }

        public boolean isUtc() {
            return this.zzg;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public static class CalendarEvent {
        private final String zza;
        private final String zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;
        private final CalendarDateTime zzf;
        private final CalendarDateTime zzg;

        public CalendarEvent(String str, String str2, String str3, String str4, String str5, CalendarDateTime calendarDateTime, CalendarDateTime calendarDateTime2) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = str5;
            this.zzf = calendarDateTime;
            this.zzg = calendarDateTime2;
        }

        public String getDescription() {
            return this.zzb;
        }

        public CalendarDateTime getEnd() {
            return this.zzg;
        }

        public String getLocation() {
            return this.zzc;
        }

        public String getOrganizer() {
            return this.zzd;
        }

        public CalendarDateTime getStart() {
            return this.zzf;
        }

        public String getStatus() {
            return this.zze;
        }

        public String getSummary() {
            return this.zza;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public static class ContactInfo {
        private final PersonName zza;
        private final String zzb;
        private final String zzc;
        private final List<Phone> zzd;
        private final List<Email> zze;
        private final List<String> zzf;
        private final List<Address> zzg;

        public ContactInfo(PersonName personName, String str, String str2, List<Phone> list, List<Email> list2, List<String> list3, List<Address> list4) {
            this.zza = personName;
            this.zzb = str;
            this.zzc = str2;
            this.zzd = list;
            this.zze = list2;
            this.zzf = list3;
            this.zzg = list4;
        }

        public List<Address> getAddresses() {
            return this.zzg;
        }

        public List<Email> getEmails() {
            return this.zze;
        }

        public PersonName getName() {
            return this.zza;
        }

        public String getOrganization() {
            return this.zzb;
        }

        public List<Phone> getPhones() {
            return this.zzd;
        }

        public String getTitle() {
            return this.zzc;
        }

        public List<String> getUrls() {
            return this.zzf;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public static class DriverLicense {
        private final String zza;
        private final String zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;
        private final String zzf;
        private final String zzg;
        private final String zzh;
        private final String zzi;
        private final String zzj;
        private final String zzk;
        private final String zzl;
        private final String zzm;
        private final String zzn;

        public DriverLicense(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = str5;
            this.zzf = str6;
            this.zzg = str7;
            this.zzh = str8;
            this.zzi = str9;
            this.zzj = str10;
            this.zzk = str11;
            this.zzl = str12;
            this.zzm = str13;
            this.zzn = str14;
        }

        public String getAddressCity() {
            return this.zzg;
        }

        public String getAddressState() {
            return this.zzh;
        }

        public String getAddressStreet() {
            return this.zzf;
        }

        public String getAddressZip() {
            return this.zzi;
        }

        public String getBirthDate() {
            return this.zzm;
        }

        public String getDocumentType() {
            return this.zza;
        }

        public String getExpiryDate() {
            return this.zzl;
        }

        public String getFirstName() {
            return this.zzb;
        }

        public String getGender() {
            return this.zze;
        }

        public String getIssueDate() {
            return this.zzk;
        }

        public String getIssuingCountry() {
            return this.zzn;
        }

        public String getLastName() {
            return this.zzd;
        }

        public String getLicenseNumber() {
            return this.zzj;
        }

        public String getMiddleName() {
            return this.zzc;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public static class Email {
        public static final int TYPE_HOME = 2;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WORK = 1;
        private final int zza;
        private final String zzb;
        private final String zzc;
        private final String zzd;

        @Retention(RetentionPolicy.CLASS)
        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
        public @interface FormatType {
        }

        public Email(int i, String str, String str2, String str3) {
            this.zza = i;
            this.zzb = str;
            this.zzc = str2;
            this.zzd = str3;
        }

        public String getAddress() {
            return this.zzb;
        }

        public String getBody() {
            return this.zzd;
        }

        public String getSubject() {
            return this.zzc;
        }

        public int getType() {
            return this.zza;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public static class GeoPoint {
        private final double zza;
        private final double zzb;

        public GeoPoint(double d, double d2) {
            this.zza = d;
            this.zzb = d2;
        }

        public double getLat() {
            return this.zza;
        }

        public double getLng() {
            return this.zzb;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public static class PersonName {
        private final String zza;
        private final String zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;
        private final String zzf;
        private final String zzg;

        public PersonName(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = str5;
            this.zzf = str6;
            this.zzg = str7;
        }

        public String getFirst() {
            return this.zzd;
        }

        public String getFormattedName() {
            return this.zza;
        }

        public String getLast() {
            return this.zzf;
        }

        public String getMiddle() {
            return this.zze;
        }

        public String getPrefix() {
            return this.zzc;
        }

        public String getPronunciation() {
            return this.zzb;
        }

        public String getSuffix() {
            return this.zzg;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public static class Phone {
        public static final int TYPE_FAX = 3;
        public static final int TYPE_HOME = 2;
        public static final int TYPE_MOBILE = 4;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WORK = 1;
        private final String zza;
        private final int zzb;

        @Retention(RetentionPolicy.CLASS)
        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
        public @interface FormatType {
        }

        public Phone(String str, int i) {
            this.zza = str;
            this.zzb = i;
        }

        public String getNumber() {
            return this.zza;
        }

        public int getType() {
            return this.zzb;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public static class Sms {
        private final String zza;
        private final String zzb;

        public Sms(String str, String str2) {
            this.zza = str;
            this.zzb = str2;
        }

        public String getMessage() {
            return this.zza;
        }

        public String getPhoneNumber() {
            return this.zzb;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public static class UrlBookmark {
        private final String zza;
        private final String zzb;

        public UrlBookmark(String str, String str2) {
            this.zza = str;
            this.zzb = str2;
        }

        public String getTitle() {
            return this.zza;
        }

        public String getUrl() {
            return this.zzb;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public static class WiFi {
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_WEP = 3;
        public static final int TYPE_WPA = 2;
        private final String zza;
        private final String zzb;
        private final int zzc;

        @Retention(RetentionPolicy.CLASS)
        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
        public @interface EncryptionType {
        }

        public WiFi(String str, String str2, int i) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = i;
        }

        public int getEncryptionType() {
            return this.zzc;
        }

        public String getPassword() {
            return this.zzb;
        }

        public String getSsid() {
            return this.zza;
        }
    }

    public Barcode(zzk zzk) {
        this.zza = (zzk) Preconditions.checkNotNull(zzk);
    }

    public Rect getBoundingBox() {
        return this.zza.zzc();
    }

    public CalendarEvent getCalendarEvent() {
        return this.zza.zzd();
    }

    public ContactInfo getContactInfo() {
        return this.zza.zze();
    }

    public Point[] getCornerPoints() {
        return this.zza.zzp();
    }

    public String getDisplayValue() {
        return this.zza.zzm();
    }

    public DriverLicense getDriverLicense() {
        return this.zza.zzf();
    }

    public Email getEmail() {
        return this.zza.zzg();
    }

    public int getFormat() {
        int zza2 = this.zza.zza();
        if (zza2 > 4096) {
            return -1;
        }
        if (zza2 == 0) {
            return -1;
        }
        return zza2;
    }

    public GeoPoint getGeoPoint() {
        return this.zza.zzh();
    }

    public Phone getPhone() {
        return this.zza.zzi();
    }

    public byte[] getRawBytes() {
        byte[] zzo = this.zza.zzo();
        if (zzo != null) {
            return Arrays.copyOf(zzo, zzo.length);
        }
        return null;
    }

    public String getRawValue() {
        return this.zza.zzn();
    }

    public Sms getSms() {
        return this.zza.zzj();
    }

    public UrlBookmark getUrl() {
        return this.zza.zzk();
    }

    public int getValueType() {
        return this.zza.zzb();
    }

    public WiFi getWifi() {
        return this.zza.zzl();
    }
}
