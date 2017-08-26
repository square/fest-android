package org.assertj.android.api.net;

/**
 * All assertions supported on Uri values by {@link UriAssert}. The interface exists
 * to ensure that {@link UriQueryParamAssert} maintains a full set of proxy methods.
 */
public interface UriAssertions<T extends UriAssertions> {
    T hasPath(String path);
    T hasNoPath();
    T hasPort(int port);
    T hasHost(String host);
    T hasFragment(String fragment);
    T hasNoFragment();
    T hasQuery(String query);
    T hasNoQuery();
    T hasScheme(String scheme);
    T hasUserInfo(String userInfo);
    T hasNoUserInfo();
    T hasAuthority(String authority);
    T hasQueryParameters(String... params);
    UriQueryParamAssert hasQueryParameter(String param);
}
