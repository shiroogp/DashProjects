package com.drew.metadata.exif;

public class ExifThumbnailDescriptor extends ExifDescriptorBase<ExifThumbnailDirectory> {
    public ExifThumbnailDescriptor(ExifThumbnailDirectory exifThumbnailDirectory) {
        super(exifThumbnailDirectory);
    }

    public String getDescription(int i) {
        if (i == 513) {
            return getThumbnailOffsetDescription();
        }
        if (i != 514) {
            return super.getDescription(i);
        }
        return getThumbnailLengthDescription();
    }

    public String getThumbnailLengthDescription() {
        String string = ((ExifThumbnailDirectory) this._directory).getString(514);
        if (string == null) {
            return null;
        }
        return string + " bytes";
    }

    public String getThumbnailOffsetDescription() {
        String string = ((ExifThumbnailDirectory) this._directory).getString(513);
        if (string == null) {
            return null;
        }
        return string + " bytes";
    }
}
