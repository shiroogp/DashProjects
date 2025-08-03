package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzg;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.LocalModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public class LocalModelLoader {
    private MappedByteBuffer zza;
    private final Context zzb;
    private final LocalModel zzc;

    public LocalModelLoader(Context context, LocalModel localModel) {
        this.zzb = context;
        this.zzc = localModel;
    }

    public LocalModel getLocalModel() {
        return this.zzc;
    }

    public MappedByteBuffer load() throws MlKitException {
        AssetFileDescriptor zza2;
        AssetFileDescriptor openFd;
        String str;
        RandomAccessFile randomAccessFile;
        Preconditions.checkNotNull(this.zzb, "Context can not be null");
        Preconditions.checkNotNull(this.zzc, "Model source can not be null");
        MappedByteBuffer mappedByteBuffer = this.zza;
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        String absoluteFilePath = this.zzc.getAbsoluteFilePath();
        String assetFilePath = this.zzc.getAssetFilePath();
        Uri uri = this.zzc.getUri();
        if (absoluteFilePath != null) {
            try {
                randomAccessFile = new RandomAccessFile(absoluteFilePath, "r");
                FileChannel channel = randomAccessFile.getChannel();
                this.zza = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                randomAccessFile.close();
                return this.zza;
            } catch (IOException e) {
                String valueOf = String.valueOf(this.zzc.getAbsoluteFilePath());
                if (valueOf.length() != 0) {
                    str = "Can not open the local file: ".concat(valueOf);
                } else {
                    str = new String("Can not open the local file: ");
                }
                throw new MlKitException(str, 14, e);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else if (assetFilePath != null) {
            try {
                openFd = this.zzb.getAssets().openFd(assetFilePath);
                this.zza = new FileInputStream(openFd.getFileDescriptor()).getChannel().map(FileChannel.MapMode.READ_ONLY, openFd.getStartOffset(), openFd.getDeclaredLength());
                if (openFd != null) {
                    openFd.close();
                }
                return this.zza;
            } catch (IOException e2) {
                StringBuilder sb = new StringBuilder(assetFilePath.length() + CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256);
                sb.append("Can not load the file from asset: ");
                sb.append(assetFilePath);
                sb.append(". Please double check your asset file name and ensure it's not compressed. See documentation for details how to use aaptOptions to skip file compression");
                throw new MlKitException(sb.toString(), 14, e2);
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else if (uri != null) {
            try {
                zza2 = zzg.zza(this.zzb, uri, "r");
                this.zza = zza2.createInputStream().getChannel().map(FileChannel.MapMode.READ_ONLY, zza2.getStartOffset(), zza2.getLength());
                if (zza2 != null) {
                    zza2.close();
                }
                return this.zza;
            } catch (IOException e3) {
                String valueOf2 = String.valueOf(uri);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
                sb2.append("Can not load the file from URI: ");
                sb2.append(valueOf2);
                throw new MlKitException(sb2.toString(), 14, e3);
            } catch (Throwable th3) {
                th.addSuppressed(th3);
            }
        } else {
            throw new MlKitException("Can not load the model. One of filePath, assetFilePath or URI must be set for the model.", 14);
        }
        throw th;
        throw th;
        throw th;
    }
}
