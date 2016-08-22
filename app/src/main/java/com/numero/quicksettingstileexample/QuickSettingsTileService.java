package com.numero.quicksettingstileexample;

import android.content.Intent;
import android.os.IBinder;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.widget.Toast;

public class QuickSettingsTileService extends TileService{

    @Override
    public int onStartCommand(Intent intent, int flags, int startID) {
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onClick() {
        switch (getQsTile().getState()){
            case Tile.STATE_ACTIVE:
                getQsTile().setState(Tile.STATE_INACTIVE);
                break;
            case Tile.STATE_INACTIVE:
                getQsTile().setState(Tile.STATE_ACTIVE);
                break;
        }
        getQsTile().updateTile();
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
    }

}
