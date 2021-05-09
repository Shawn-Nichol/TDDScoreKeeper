![TDD]
# TDDScoreKeeper
TDDScoreKeeper is an app that use android development best practices with Android jetpack. This app
is used to practice test driven development.

![TDD](https://user-images.githubusercontent.com/30714313/117563199-753a3f80-b061-11eb-9dc4-a208c0695aea.PNG)


## Libraries used

- [Architecture][00] - A collection of libraries that help design robust, testable, and maintainable apps.
  - [DataBinding][01] - Declarative bind observable data to UI elements.
  - [LiveData][02] - Build data objects that notify views when the underlying database changes.
  - [Navigation][03] - Handle everything needed for in-app navigation.
  - [ViewModel][04] - Store UI related data that isn't destroyed on app rotations.
-[Dependency Injection][50] - Reference other classes.
  - [Dagger][51] - Dagger automatically generates code that mimics the code you would otherwise
  have hand-written.

- [UI][30] - Details on why and how to use UI components in your apps - Together or separate
  - [Fragment][31] - A basic unit of composable UI.
  - [Layout][32] - Lay out widgets using different algorithms.

- [Testing][90] Allows you to verify the correctness function behavior, and usability before release.
  - [Espresso][91] - Use a espresso to write UI tests.
  - [Mocktio][92] - Is a mocking framework, that produces verification errors.
  - [Robolectic][93] - Is a frame work that brings fast reliable unit tests, Tests run inside the JVM.




[00]: https://developer.android.com/jetpack/arch/
[01]: https://developer.android.com/topic/libraries/data-binding/
[02]: https://developer.android.com/topic/libraries/architecture/livedata
[03]: https://developer.android.com/topic/libraries/architecture/navigation/
[04]: https://developer.android.com/topic/libraries/architecture/viewmodel
[30]: https://developer.android.com/guide/topics/ui
[31]: https://developer.android.com/guide/components/fragments
[32]: https://developer.android.com/guide/topics/ui/declaring-layout
[50]: https://developer.android.com/training/dependency-injection
[51]: https://developer.android.com/training/dependency-injection/dagger-basics
[90]: https://developer.android.com/training/testing
[91]: https://developer.android.com/training/testing/espresso
[92]: https://site.mockito.org/
[93]: http://robolectric.org/
