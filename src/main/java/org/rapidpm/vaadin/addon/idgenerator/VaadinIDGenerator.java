/**
 * Copyright © 2018 Sven Ruppert (sven.ruppert@gmail.com)
 *
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
/*
  Copyright © 2018 Sven Ruppert (sven.ruppert@gmail.com)

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package org.rapidpm.vaadin.addon.idgenerator;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.component.upload.Upload;
import org.rapidpm.frp.functions.TriFunction;

import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * The basic interface for the ID Generator
 */
public interface VaadinIDGenerator {

  /**
   * Will give you a generic ID Generator
   * @return a TriFunction
   */
  static TriFunction<Class, Class, String, String> genericID() {
    return (uiClass, componentClass, label) -> (uiClass.getSimpleName()
                                                + "-"
                                                + componentClass.getSimpleName()
                                                + "-"
                                                + label.replace(" ", "-")).toLowerCase(Locale.US);
  }

  /**
   *
   * @return a reduced version of the genericID Function
   */
  static Function<Class, BiFunction<Class, String, String>> typedComponentIDGenerator() {
    return (clazz) -> (uiClass, label) -> genericID().apply(uiClass, clazz, label);
  }


  static Function<String, String> caption() {
    return (id) -> id + "." + "caption";
  }

  static Function<String, String> placeholder() {
    return (id) -> id + "." + "placeholder";
  }


  static BiFunction<Class, String, String> gridID() {
    return typedComponentIDGenerator().apply(Grid.class);
  }

//  static BiFunction<Class, String, String> gridProID() {
//    return typedComponentIDGenerator().apply(GridPro.class);
//  }

  static BiFunction<Class, String, String> buttonID() {
    return typedComponentIDGenerator().apply(Button.class);
  }

  static BiFunction<Class, String, String> comboBoxID() {
    return typedComponentIDGenerator().apply(ComboBox.class);
  }

  static BiFunction<Class, String, String> datePickerID() {
    return typedComponentIDGenerator().apply(DatePicker.class);
  }

  static BiFunction<Class, String, String> labelID() {
    return typedComponentIDGenerator().apply(Label.class);
  }

  static BiFunction<Class, String, String> spanID() {
    return typedComponentIDGenerator().apply(Span.class);
  }

  static BiFunction<Class, String, String> textfieldID() {
    return typedComponentIDGenerator().apply(TextField.class);
  }

  static BiFunction<Class, String, String> passwordID() {
    return typedComponentIDGenerator().apply(PasswordField.class);
  }

  static BiFunction<Class, String, String> checkboxID() {
    return typedComponentIDGenerator().apply(Checkbox.class);
  }

  static BiFunction<Class, String, String> contextMenuID() {
    return typedComponentIDGenerator().apply(ContextMenu.class);
  }

  static BiFunction<Class, String, String> timePickerID() {
    return typedComponentIDGenerator().apply(TimePicker.class);
  }

  static BiFunction<Class, String, String> detailsID() {
    return typedComponentIDGenerator().apply(Details.class);
  }

  static BiFunction<Class, String, String> dialogID() {
    return typedComponentIDGenerator().apply(Dialog.class);
  }

  static BiFunction<Class, String, String> selectID() {
    return typedComponentIDGenerator().apply(Select.class);
  }

  static BiFunction<Class, String, String> iconID() {
    return typedComponentIDGenerator().apply(Icon.class);
  }

  static BiFunction<Class, String, String> listBoxID() {
    return typedComponentIDGenerator().apply(ListBox.class);
  }

  static BiFunction<Class, String, String> progressBarID() {
    return typedComponentIDGenerator().apply(ProgressBar.class);
  }

  static BiFunction<Class, String, String> radioBtnGrpID() {
    return typedComponentIDGenerator().apply(RadioButtonGroup.class);
  }

  static BiFunction<Class, String, String> tabID() {
    return typedComponentIDGenerator().apply(Tab.class);
  }

  static BiFunction<Class, String, String> uploadID() {
    return typedComponentIDGenerator().apply(Upload.class);
  }

  static BiFunction<Class, String, String> customFieldID() {
    return typedComponentIDGenerator().apply(CustomField.class);
  }

//  static BiFunction<Class, String, String> chartID() {
//    return typedComponentIDGenerator().apply(Chart.class);
//  }

//  static BiFunction<Class, String, String> richTextEditorID() {
//    return typedComponentIDGenerator().apply(RichTextEditor.class);
//  }
//
//  static BiFunction<Class, String, String> crudID() {
//    return typedComponentIDGenerator().apply(Crud.class);
//  }
//
//  static BiFunction<Class, String, String> cookieConsentID() {
//    return typedComponentIDGenerator().apply(CookieConsent.class);
//  }
//
//  static BiFunction<Class, String, String> confirmDialogID() {
//    return typedComponentIDGenerator().apply(ConfirmDialog.class);
//  }


//  static BiFunction<Class, String, String> itemID() {
//    return typedComponentIDGenerator().apply(Item.class);
//  }

//  static BiFunction<Class, String, String> accordeonID() {
//    return typedComponentIDGenerator().apply(.class);
//  }

//  Layouts

  static BiFunction<Class, String, String> verticalLayoutID() {
    return typedComponentIDGenerator().apply(VerticalLayout.class);
  }

  static BiFunction<Class, String, String> horizontalLayoutID() {
    return typedComponentIDGenerator().apply(HorizontalLayout.class);
  }

  static BiFunction<Class, String, String> formLayoutID() {
    return typedComponentIDGenerator().apply(FormLayout.class);
  }

  static BiFunction<Class, String, String> splitLayoutID() {
    return typedComponentIDGenerator().apply(SplitLayout.class);
  }
}
