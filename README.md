This is a Compose Multiplatform application that demonstrates an odd state saving/management issue. Reproducing is very simple:

1. Build and run the application
   1. On the only screen in the application, note the values of the fields:
   1. The `Foo` combobox/spinner is set to `Foo 1`
   1. The child combos are `1`, `2`, and `3`.
1. If you change `Foo` to `Foo 2`, the child values do not change
   1. The values should be `4`, `5`, and `6`.
1. If you uncomment line 83 in `RootContent.kt` and rerun the application, you will see the child components' values update as expected.

My question is *why* is this necessary? In the application from which I distilled this example, I have similar parent/child setups that don't need the key. Is it related to `LazyColumn`? Am I missing something subtle elsewhere?
