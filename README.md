# IDGenerator for Flow

## No Vaadin Directory anymore
**This AddOn is no longer available in the Vaadin Directory**
The deployment process is way to manually. So I decided to use maven central only.

## Why this IDGenerator?
If IDs for components needed in a project, it makes sense to use an ID generator. 
With this, you get in a project ID's that always built according to the same scheme.
Relevant here is that these numbers kept in human-readable form. 
This strategy facilitates the assignment of log messages to the particular source code point later during operation.

Another requirement is the uniqueness of identification numbers. 
With this, it is the only way to guarantee that the tests based on it work flawlessly.

To use this ID generator now, you can use the static methods in the interface named **VaadinIDGenerator**. 
The method **genericID** returns a generic and neutral ID generator. 
This result is a function with three input parameters. 
Based on these parameters, the ID will be generated.

```java
  static TriFunction<Class, Class, String, String> genericID() {
    return (uiClass , componentClass , label)
        -> (uiClass.getSimpleName()
            + "-" + componentClass.getSimpleName()
            + "-" + label.replace(" " , "-"))
        .toLowerCase(Locale.US);
  }
```

To take the next step, you can specialise the ID generators on the particular component types. 
This refers to the components contained in Vaadin Flow, such as the button.

```java
  static Function<Class, BiFunction<Class, String, String>> typedComponentIDGenerator() {
    return (clazz) -> (uiClass , label) -> genericID().apply(uiClass , clazz , label);
  }
  
  static BiFunction<Class, String, String> buttonID() {
    return typedComponentIDGenerator().apply(Button.class);
  }
```

To use this ID generator, only the class which should hold the 
particular element and a logical identifier which then leads to the 
domain-specific name of the individual components is needed at the place of use.

```java
  public static final String BTN_CLICK_ME_ID = buttonID().apply(ClickCounterWorkspace.class, "btn-click-me");
  public static final String LB_CLICK_COUNT_ID = spanID().apply(ClickCounterWorkspace.class, "lb-click-count");
```

But not only identification numbers benefit from this ID generator. 
You can just as well use this method to generate unique keys for the I18n mechanism. 
Here only a slightly modified structure is used.

```java
  static Function<String, String> caption() {
    return (id) -> id + "." + "caption";
  }

  static Function<String, String> placeholder() {
    return (id) -> id + "." + "placeholder";
  }
```

## Available / typed IDGenerators
* Vaadin Grid 
* Vaadin Button 
* Vaadin Combo Box
* Vaadin Date Picker
* Vaadin Label
* Vaadin Span
* Vaadin Text Field - Text / Password
* Vaadin Checkbox
* Vaadin Ordered Layout - Horizontal / Vertical
* Vaadin Context Menu
* Vaadin Time Picker
* Vaadin Details 
* Vaadin Dialog 
* Vaadin Select
* Vaadin Form Layout
* Vaadin Icons
* Vaadin List Box 
* Vaadin Progress Bar 
* Vaadin Radio Button
* Vaadin Split Layout
* Vaadin Tabs 
* Vaadin Upload 
* Vaadin Custom Field 

* Vaadin Charts 
* Vaadin Grid Pro 
* Vaadin Rich Text Editor 
* Vaadin Crud 
* Vaadin Cookie Consent 
* Vaadin Confirm Dialog 


## Backlog
* Vaadin Accordion
* Vaadin Item 
* Vaadin Notification 
* Vaadin App Layout 
* Vaadin Login 
* Vaadin Board 
