# Privacy Policy Dialog

<img src="Screenshot.png" width="250" >

# Step 1. Add the JitPack repository to your build file
 Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

# Step 2. Add the dependency
```
	dependencies {
	        implementation "com.github.HmimssaSoufiane:PrivacyPolicyDialog:5.0.0"
		}
```
# Step 2. Go to your splash and add this code(put privacy  url and you store name)

```
 	 Bundle args = new Bundle();
            args.putString("storeName", "ArchaSoft ");
            args.putString("PrivacyURL", "https://github.com/HmimssaSoufiane/PrivacyPolicyDialog");
            PrivacyPolicyDialog dialog = new PrivacyPolicyDialog();
            dialog.setArguments(args);
            dialog.show(getSupportFragmentManager(), "Text");
            //
            final Intent goNextActivity = new Intent(this, Main2Activity.class);

            Thread daemonThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (!PrivacyPolicyDialog.isDismiss) {
                            Log.i("thread", "while");
                            Thread.sleep(1000);
                        }
                    } catch (Exception e) {
                        Log.i("thread", "Exception" + e.getMessage());


                    } finally {
                        startActivity(goNextActivity);
                        Log.i("thread", "Fin");
                        finish();
                    }
                }

            }, "Demon");

            daemonThread.start();
```
# Developed By

Salah chnitfa and Hmimssa Soufiane 
