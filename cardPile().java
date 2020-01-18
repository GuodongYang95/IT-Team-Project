{\rtf1\ansi\ansicpg1252\cocoartf1671\cocoasubrtf600
{\fonttbl\f0\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red204\green108\blue29;\red217\green232\blue247;\red230\green230\blue250;
\red128\green128\blue128;\red18\green144\blue195;\red249\green250\blue244;\red102\green225\blue248;\red30\green181\blue64;
\red104\green151\blue187;\red121\green171\blue255;\red242\green242\blue0;\red243\green236\blue121;}
{\*\expandedcolortbl;;\csgenericrgb\c80000\c42353\c11373;\csgenericrgb\c85098\c90980\c96863;\csgenericrgb\c90196\c90196\c98039;
\csgenericrgb\c50196\c50196\c50196;\csgenericrgb\c7059\c56471\c76471;\csgenericrgb\c97647\c98039\c95686;\csgenericrgb\c40000\c88235\c97255;\csgenericrgb\c11765\c70980\c25098;
\csgenericrgb\c40784\c59216\c73333;\csgenericrgb\c47451\c67059\c100000;\csgenericrgb\c94902\c94902\c0;\csgenericrgb\c95294\c92549\c47451;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs24 \cf2 package\cf3  commandline\cf4 ;\cf0 \
\
\cf2 import\cf3  \ul java\cf4 \ulc4 .\cf3 \ulc3 until\cf4 \ulnone .\cf3 \ul \ulc3 ArrayList\cf0 \ulnone \
\
\pard\pardeftab720\partightenfactor0
\cf5 /**\cf0 \
\cf5  * This attribute will be used to store the card \cf0 \
\cf5  * gotten from GameManager\cf0 \
\cf5  */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf2 public\cf3  \cf2 class\cf3  \cf6 CardPile\cf3  \cf7 \{\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3 	\cf0 \
\cf3 	\cf2 private\cf3  \cf6 \ul \ulc6 Card\cf7 \ulnone []\cf3  \cf8 cards\cf4 ;\cf3  \cf5 // The card that we generated in the Database\cf0 \
\cf3 	\cf0 \
\cf3 	\cf2 public\cf3  \cf9 CardPile\cf3  \cf7 ()\cf3  \cf7 \{\cf0 \
\cf3 		\cf0 \
\cf3 		\cf2 \ul \ulc2 this\cf4 \ulc4 .\cf8 \ulc8 cards\cf3 \ulnone  \cf4 =\cf3  \cf2 new\cf3  \cf6 \ul \ulc6 Card\cf7 \ulnone [\cf10 0\cf7 ]\cf4 ;\cf0 \
\cf3 	\cf7 \}\cf0 \
\cf3 	\cf0 \
\pard\pardeftab720\partightenfactor0
\cf7 \ul \ulc7 \}\cf0 \ulnone \
\
\pard\pardeftab720\partightenfactor0
\cf3     \cf5 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf5      * Get the size of pile\cf0 \
\cf5      */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3     \cf2 public\cf3  \cf2 int\cf3  \cf9 getPileSize\cf7 ()\cf3  \cf7 \{\cf0 \
\cf3         \cf0 \
\cf3         \cf2 return\cf3  \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf8 \ulc8 cards\cf4 \ulnone .\cf3 length\cf4 ;\cf0 \
\cf3     \cf7 \}\cf0 \
\cf3     \cf0 \
\cf3     \cf5 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf5      * Adds a given card to the end of a players hand.\cf0 \
\cf5      */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3     \cf2 public\cf3  \cf2 void\cf3  \cf9 giveCard\cf7 (\cf6 \ul \ulc6 Card\cf3 \ulnone  \cf11 newCard\cf7 )\cf3  \cf7 \{\cf0 \
\cf3         \cf0 \
\cf3         \cf6 \ul \ulc6 Card\cf7 \ulnone []\cf3  \cf12 newHand\cf3  \cf4 =\cf3  \cf2 new\cf3  \cf6 \ul \ulc6 Card\cf7 \ulnone [\cf2 \ul \ulc2 this\cf4 \ulc4 .\cf8 \ulc8 cards\cf4 \ulnone .\cf3 length\cf4 +\cf10 1\cf7 ]\cf4 ;\cf0 \
\cf3         \cf0 \
\cf3         \cf2 for\cf3  \cf7 (\cf2 int\cf3  \cf12 i\cf3  \cf4 =\cf3  \cf10 0\cf4 ;\cf3  \cf13 i\cf3  \cf4 <\cf3  \cf8 \ul \ulc8 cards\cf4 \ulnone .\cf3 length\cf4 ;\cf3  \cf13 i\cf4 ++\cf7 )\cf3  \cf7 \{\cf0 \
\cf3             \cf13 newHand\cf7 [\cf13 i\cf7 ]\cf3  \cf4 =\cf3  \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf8 \ulc8 cards\cf7 \ulnone [\cf13 i\cf7 ]\cf4 ;\cf0 \
\cf3         \cf7 \}\cf0 \
\cf3         \cf0 \
\cf3         \cf13 newHand\cf7 [\cf8 \ul \ulc8 cards\cf4 \ulnone .\cf3 length\cf7 ]\cf3  \cf4 =\cf3  \cf11 newCard\cf4 ;\cf0 \
\cf3         \cf0 \
\cf3         \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf8 \ulc8 cards\cf3 \ulnone  \cf4 =\cf3  \cf13 newHand\cf4 ;\cf0 \
\cf3     \cf7 \}\cf0 \
\cf3     \cf0 \
\cf3     \cf5 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf5      * Removes the first card from a player's hand and returns it.\cf0 \
\cf5      */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3     \cf2 public\cf3  \cf6 \ul \ulc6 Card\cf3 \ulnone  \cf9 takeCard\cf7 ()\cf3  \cf7 \{\cf0 \
\cf3         \cf0 \
\cf3         \cf6 \ul \ulc6 Card\cf3 \ulnone  \cf12 takenCard\cf3  \cf4 =\cf3  \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf8 \ulc8 cards\cf7 \ulnone [\cf10 0\cf7 ]\cf4 ;\cf3         \cf0 \
\cf3         \cf6 \ul \ulc6 Card\cf7 \ulnone []\cf3  \cf12 newHand\cf3  \cf4 =\cf3  \cf2 new\cf3  \cf6 \ul \ulc6 Card\cf7 \ulnone [\cf2 \ul \ulc2 this\cf4 \ulc4 .\cf8 \ulc8 cards\cf4 \ulnone .\cf3 length\cf4 -\cf10 1\cf7 ]\cf4 ;\cf0 \
\cf3         \cf0 \
\cf3         \cf2 for\cf3  \cf7 (\cf2 int\cf3  \cf12 i\cf3  \cf4 =\cf3  \cf10 0\cf4 ;\cf3  \cf13 i\cf3  \cf4 <\cf3  \cf13 newHand\cf4 .\cf3 length\cf4 ;\cf3  \cf13 i\cf4 ++\cf7 )\cf3  \cf7 \{\cf0 \
\cf3             \cf0 \
\cf3             \cf13 newHand\cf7 [\cf13 i\cf7 ]\cf3  \cf4 =\cf3  \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf8 \ulc8 cards\cf7 \ulnone [\cf13 i\cf4 +\cf10 1\cf7 ]\cf4 ;\cf0 \
\cf3         \cf7 \}\cf0 \
\cf3         \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf8 \ulc8 cards\cf3 \ulnone  \cf4 =\cf3  \cf13 newHand\cf4 ;\cf0 \
\cf3         \cf0 \
\cf3         \cf2 return\cf3  \cf13 takenCard\cf4 ;\cf0 \
\cf3     \cf7 \}\cf3     \cf0 \
\cf3     \cf0 \
\cf3     \cf5 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf5      * Returns the Card at a given index.\cf0 \
\cf5      */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3     \cf2 public\cf3  \cf6 \ul \ulc6 Card\cf3 \ulnone  \cf9 getCardAtIndex\cf7 (\cf2 int\cf3  \cf11 index\cf7 )\cf3  \cf7 \{\cf0 \
\cf3         \cf0 \
\cf3         \cf2 return\cf3  \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf8 \ulc8 cards\cf7 \ulnone [\cf11 index\cf7 ]\cf4 ;\cf0 \
\cf3     \cf7 \}\cf0 \
\pard\pardeftab720\partightenfactor0
\cf7 \}}