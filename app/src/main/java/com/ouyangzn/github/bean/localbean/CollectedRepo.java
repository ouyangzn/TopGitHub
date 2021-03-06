/*
 * Copyright (c) 2016.  ouyangzn   <email : ouyangzn@163.com>
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

package com.ouyangzn.github.bean.localbean;

import com.ouyangzn.github.bean.apibean.Repository;
import com.ouyangzn.github.bean.apibean.User;
import com.ouyangzn.github.db.convert.CollectedRepoOwnerConvert;
import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;

/**
 * Created by ouyangzn on 2016/9/27.<br/>
 * Description：
 */
@Entity(nameInDb = "COLLECTED_REPO", indexes = {
    @Index(value = "id", unique = true)
}) public class CollectedRepo {

  @Id(autoincrement = false) private Long id;
  private long collectTime;
  private String htmlUrl;
  private String fullName;
  private String language;
  private int stargazersCount;
  @Convert(converter = CollectedRepoOwnerConvert.class, columnType = String.class)
  private CollectedRepoOwner owner;
  private String description;

  @Generated(hash = 1441903010)
  public CollectedRepo(Long id, long collectTime, String htmlUrl, String fullName, String language,
      int stargazersCount, CollectedRepoOwner owner, String description) {
    this.id = id;
    this.collectTime = collectTime;
    this.htmlUrl = htmlUrl;
    this.fullName = fullName;
    this.language = language;
    this.stargazersCount = stargazersCount;
    this.owner = owner;
    this.description = description;
  }

  @Generated(hash = 813661088) public CollectedRepo() {
  }

  public void convert(Repository repo) {
    this.id = repo.getId().longValue();
    this.htmlUrl = repo.getHtmlUrl();
    this.fullName = repo.getFullName();
    this.language = repo.getLanguage();
    this.stargazersCount = repo.getStargazersCount();
    this.description = repo.getDescription();
    this.owner = new CollectedRepoOwner();
    User owner = repo.getOwner();
    this.owner.convert(owner);
  }

  @Override public String toString() {
    return "CollectedRepo{"
        + "id="
        + id
        + ", collectTime="
        + collectTime
        + ", htmlUrl='"
        + htmlUrl
        + '\''
        + ", fullName='"
        + fullName
        + '\''
        + ", language='"
        + language
        + '\''
        + ", stargazersCount="
        + stargazersCount
        + ", owner="
        + owner
        + ", description='"
        + description
        + '\''
        + '}';
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public long getCollectTime() {
    return this.collectTime;
  }

  public void setCollectTime(long collectTime) {
    this.collectTime = collectTime;
  }

  public String getHtmlUrl() {
    return this.htmlUrl;
  }

  public void setHtmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
  }

  public String getFullName() {
    return this.fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getLanguage() {
    return this.language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public int getStargazersCount() {
    return this.stargazersCount;
  }

  public void setStargazersCount(int stargazersCount) {
    this.stargazersCount = stargazersCount;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CollectedRepoOwner getOwner() {
    return this.owner;
  }

  public void setOwner(CollectedRepoOwner owner) {
    this.owner = owner;
  }

}
