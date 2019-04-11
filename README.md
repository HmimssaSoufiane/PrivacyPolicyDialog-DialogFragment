# Privacy Policy Dialog

<img src="Capture.PNG" width="250" >

<h1>Step 1. Add the JitPack repository to your build file</h1>
Add it in your root build.gradle at the end of repositories:<br>
<code>
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
</code>
<h1>Step 2. Add the dependency</h1>
<code>
	dependencies {
	        implementation "com.github.HmimssaSoufiane:PrivacyPolicyDialog:2.0.0"
		}
		</code>
<h1>Step 2. Add your privacy and you storename</h1>
<code>
 	Bundle args = new Bundle();<br>
        args.putString("storeName","ArchaSoft ");<br>
        args.putString("PrivacyURL","https://github.com/HmimssaSoufiane/PrivacyPolicyDialog");<br>
        PrivacyPolicyDialog dialog=new PrivacyPolicyDialog();<br>
        dialog.setArguments(args);<br>
        dialog.show(getSupportFragmentManager(), "Text");<br>
</code>
