package com.drew.metadata.jpeg;

import com.drew.metadata.TagDescriptor;

public class JpegCommentDescriptor extends TagDescriptor<JpegCommentDirectory> {
    public JpegCommentDescriptor(JpegCommentDirectory jpegCommentDirectory) {
        super(jpegCommentDirectory);
    }

    public String getJpegCommentDescription() {
        return ((JpegCommentDirectory) this._directory).getString(0);
    }
}
