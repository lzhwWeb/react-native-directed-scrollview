package com.rnds;

import android.support.annotation.Nullable;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.views.scroll.ScrollEventType;

import java.util.Map;

class DirectedScrollViewManager extends ViewGroupManager<DirectedScrollView> {

  @Override
  public String getName() {
    return "DirectedScrollView";
  }

  @Override
  public DirectedScrollView createViewInstance(ThemedReactContext context) {
    return new DirectedScrollView(context);
  }

  @Override
  public Map<String,Integer> getCommandsMap() {
    return MapBuilder.of("scrollTo", 1);
  }

  @Override
  public void receiveCommand(DirectedScrollView view, int commandType, @Nullable ReadableArray args) {
    super.receiveCommand(view, commandType, args);
    if (commandType == 1) {
      Double translateX = args.getDouble(0);
      Double translateY = args.getDouble(1);
      Boolean animated = args.getBoolean(2);

      view.scrollTo(translateX, translateY, animated);
    }
  }

  @Override
  public @Nullable Map getExportedCustomDirectEventTypeConstants() {
    return createExportedCustomDirectEventTypeConstants();
  }

  public static Map createExportedCustomDirectEventTypeConstants() {
    return MapBuilder.builder()
        .put(ScrollEventType.SCROLL.getJSEventName(), MapBuilder.of("registrationName", "onScroll"))
        .put(ScrollEventType.BEGIN_DRAG.getJSEventName(), MapBuilder.of("registrationName", "onScrollBeginDrag"))
        .put(ScrollEventType.END_DRAG.getJSEventName(), MapBuilder.of("registrationName", "onScrollEndDrag"))
        .put(ScrollEventType.MOMENTUM_BEGIN.getJSEventName(), MapBuilder.of("registrationName", "onMomentumScrollBegin"))
        .put(ScrollEventType.MOMENTUM_END.getJSEventName(), MapBuilder.of("registrationName", "onMomentumScrollEnd"))
        .build();
  }

  @ReactProp(name = "minimumZoomScale", defaultFloat = 1.0f)
  public void setMinimumZoomScale(DirectedScrollView view, @Nullable float minimumZoomScale) {
    view.setMinimumZoomScale(minimumZoomScale);
  }

  @ReactProp(name = "maximumZoomScale", defaultFloat = 1.0f)
  public void setMaximumZoomScale(DirectedScrollView view, @Nullable float maximumZoomScale) {
    view.setMaximumZoomScale(maximumZoomScale);
  }

  @ReactProp(name = "bounces", defaultBoolean = true)
  public void setBounces(DirectedScrollView view, @Nullable boolean bounces) {
    view.setBounces(bounces);
  }

  @ReactProp(name = "bouncesZoom", defaultBoolean = true)
  public void setBouncesZoom(DirectedScrollView view, @Nullable boolean bouncesZoom) {
    view.setBouncesZoom(bouncesZoom);
  }

  @ReactProp(name = "alwaysBounceHorizontal", defaultBoolean = true)
  public void setAlwaysBounceHorizontal(DirectedScrollView view, @Nullable boolean alwaysBounceHorizontal) {
    view.setAlwaysBounceHorizontal(alwaysBounceHorizontal);
  }

  @ReactProp(name = "alwaysBounceVertical", defaultBoolean = true)
  public void setAlwaysBounceVertical(DirectedScrollView view, @Nullable boolean alwaysBounceVertical) {
    view.setAlwaysBounceVertical(alwaysBounceVertical);
  }

  @ReactProp(name = "scrollEnabled", defaultBoolean = true)
  public void setScrollEnabled(DirectedScrollView view, @Nullable boolean scrollEnabled) {
    view.setScrollEnabled(scrollEnabled);
  }
}
