## happy path
* greet
  - utter_greet
* mood_great
  - utter_happy

## sad path 1
* greet
  - utter_greet

* affirm
  - utter_happy

## sad path 2
* greet
  - utter_greet
* deny
  - utter_goodbye

## say goodbye
* goodbye
  - utter_goodbye

## bot challenge
* bot_challenge
  - utter_iamabot

## corona cases
* corona_cases_info
  - corona_cases_action

## corona safety
* corona_safety
  - utter_safety
