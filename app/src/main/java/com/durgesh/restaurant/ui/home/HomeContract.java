package com.durgesh.restaurant.ui.home;

/**
 * Created by durgeshtrivedi on 15/12/17.
 */

import com.durgesh.restaurant.ui.BasePresenter;
import com.durgesh.restaurant.ui.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface HomeContract {

    interface View extends BaseView<Presenter> {

      //  void setLoadingIndicator(boolean active);

    }

    interface Presenter extends BasePresenter<View> {

       // void result(int requestCode, int resultCode);

       // void loadTasks(boolean forceUpdate);

    }
}

