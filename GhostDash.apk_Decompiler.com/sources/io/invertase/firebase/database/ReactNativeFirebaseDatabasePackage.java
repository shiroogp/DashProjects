package io.invertase.firebase.database;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReactNativeFirebaseDatabasePackage implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ReactNativeFirebaseDatabaseModule(reactApplicationContext));
        arrayList.add(new ReactNativeFirebaseDatabaseReferenceModule(reactApplicationContext));
        arrayList.add(new ReactNativeFirebaseDatabaseQueryModule(reactApplicationContext));
        arrayList.add(new ReactNativeFirebaseDatabaseOnDisconnectModule(reactApplicationContext));
        arrayList.add(new ReactNativeFirebaseDatabaseTransactionModule(reactApplicationContext));
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
