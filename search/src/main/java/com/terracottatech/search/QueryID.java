/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package com.terracottatech.search;

public final class QueryID {
  public final long requesterId;
  public final long queryId;
  private final int hash;

  public QueryID(long requesterId, long queryId) {
    this.requesterId = requesterId;
    this.queryId = queryId;
    hash = computeHash();
  }

  private int computeHash() {
    final int prime = 31;
    int result = prime + (int) (requesterId ^ (requesterId >>> 32));
    result = prime * result + (int) (queryId ^ (queryId >>> 32));

    return result;
  }

  @Override
  public int hashCode() {
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof QueryID)) return false;
    QueryID q2 = (QueryID) obj;
    return requesterId == q2.requesterId && queryId == q2.queryId;
  }

  @Override
  public String toString() {
    return new StringBuilder(128).append("requesterId=").append(requesterId).append(", queryId=").append(queryId)
        .toString();
  }

}