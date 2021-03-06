/*
 * Copyright (c) 2016.  ouyangzn   <ouyangzn@163.com>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ouyangzn.github.network;

import com.ouyangzn.github.App;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ouyangzn on 2016/9/5.<br/>
 * Description：
 */
public class Api {

  private Api() {}

  public static SearchApi getSearchApi() {
    return getRetrofitBuilder()
        .build()
        .create(SearchApi.class);
  }

  public static UserApi getUserApi() {
    return getRetrofitBuilder().build().create(UserApi.class);
  }

  private static Retrofit.Builder getRetrofitBuilder() {
    return new Retrofit.Builder().baseUrl("https://api.github.com")
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(App.getApp().getGson()))
        .client(HttpClient.getDefaultHttpClient());
  }
}
