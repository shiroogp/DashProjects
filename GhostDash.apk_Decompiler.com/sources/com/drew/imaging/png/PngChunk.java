package com.drew.imaging.png;

public class PngChunk {
    private final byte[] _bytes;
    private final PngChunkType _chunkType;

    public PngChunk(PngChunkType pngChunkType, byte[] bArr) {
        this._chunkType = pngChunkType;
        this._bytes = bArr;
    }

    public PngChunkType getType() {
        return this._chunkType;
    }

    public byte[] getBytes() {
        return this._bytes;
    }
}
