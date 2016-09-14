package com.wTouch2KiLL.media.camera;

import android.os.Environment;
import java.io.File;

public final class FroyoAlbumDirFactory extends AlbumStorageDirFactory {
    public File getAlbumStorageDir(String albumName) {
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), albumName);
    }
}
