package com.makemytrip.base;

public interface Locators {

	String login_Close_popup_btn = "span.commonModal__close";
	String menu_Trains = "li[data-cy=\"menu_Trains\"]";
	String from_textbox = "div[data-cy=\"RailSearchWidget_338\"]";
	String from_inputbox = "input[aria-controls=\"react-autowhatever-1\"]";
	String from_select_item_from_list = "li#react-autowhatever-1-section-0-item-1";

	String to_textbox = "div[data-cy=\"RailSearchWidget_339\"]";
	String to_inputbox = "input.react-autosuggest__input.react-autosuggest__input--open";

	String to_select_item_from_list = "li#react-autowhatever-1-section-0-item-0";

	String travel_dateBox = "div[data-cy=\"RailSearchWidget_340\"]";

	String travel_date_select = "div[aria-label=\"Wed Jul 09 2025\"]";

	String travel_class = "ul[class='travelForPopup']>li[data-cy='FC']";

	String search_button = "a[data-cy=\"submit\"]";

}
