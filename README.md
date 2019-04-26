# RNS-Android-SDK

Implementation for resolvers for the RIF Name Service, available for Android.

## Testing

To run unit tests, clone this repository.

Install ``Ganache-cli`` for a local blockchain

  `$ npm install -g ganache-cli`

  `$ ganache-cli`

Then you can run your test in your Android Studio or any IDE you are running

## Import into your app


Clone this project.

```console
user@computer:~/some/path/$ git clone git@github.com:rnsdomains/RNS-SDK-android.git
Cloning into 'RNS-SDK-android'...
```

Import using AndroidStudio

File -> New -> Import Module...

![Import Module Dialog](/images/ImportFromSource.png)

## How to use

You will need access to a running rsk node that can made calls to the JSON-RPC. For this we have our public nodes available for you, that are already configured in our `build.gradle` file. You can change this or use the constructors for the resolver that will be described bellow.

```
  defaultConfig {
      //Configuration for prod
      buildConfigField "String", "NODE", '"https://public-node.rsk.co"'
      buildConfigField "String", "RESOLVER_ADDRESS", '"0x4efd25e3d348f8f25a14fb7655fba6f72edfe93a"'
  }
```

You should just create your resolver with the default constructor if you are going to use mainnet.

```java
 RnsResolver resolver = new RnsResolver();
```

Or you can use another constructor if you want to use a personal node.

```java
 RnsResolver resolver = new RnsResolver("http://your.node.org", "RSK_ADDRES_TO_RESOLVER");
```

Then you can start using your resolver in the [AsyncTask](https://developer.android.com/reference/android/os/AsyncTask) defined in the android API.
