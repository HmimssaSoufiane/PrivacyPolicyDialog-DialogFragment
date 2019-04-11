# Privacy Policy Dialog

<img src="Capture.PNG" width="250" >

<h1>Step 1. Add the JitPack repository to your build file</h1>
Add it in your root build.gradle at the end of repositories:<br>

`
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
`
<h1>Step 2. Add the dependency</h1>

	dependencies {
	        implementation "com.github.HmimssaSoufiane:PrivacyPolicyDialog:2.0.0"
		}

