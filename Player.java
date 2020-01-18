{\rtf1\ansi\ansicpg1252\cocoartf1671\cocoasubrtf600
{\fonttbl\f0\fnil\fcharset0 Menlo-Regular;\f1\fnil\fcharset0 Menlo-Bold;}
{\colortbl;\red255\green255\blue255;\red204\green108\blue29;\red217\green232\blue247;\red230\green230\blue250;
\red18\green144\blue195;\red249\green250\blue244;\red102\green225\blue248;\red128\green128\blue128;\red30\green181\blue64;
\red121\green171\blue255;\red104\green151\blue187;\red154\green140\blue124;\red242\green242\blue0;\red243\green236\blue121;
\red167\green236\blue33;}
{\*\expandedcolortbl;;\csgenericrgb\c80000\c42353\c11373;\csgenericrgb\c85098\c90980\c96863;\csgenericrgb\c90196\c90196\c98039;
\csgenericrgb\c7059\c56471\c76471;\csgenericrgb\c97647\c98039\c95686;\csgenericrgb\c40000\c88235\c97255;\csgenericrgb\c50196\c50196\c50196;\csgenericrgb\c11765\c70980\c25098;
\csgenericrgb\c47451\c67059\c100000;\csgenericrgb\c40784\c59216\c73333;\csgenericrgb\c60392\c54902\c48627;\csgenericrgb\c94902\c94902\c0;\csgenericrgb\c95294\c92549\c47451;
\csgenericrgb\c65490\c92549\c12941;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs24 \cf2 package\cf3  commandline\cf4 ;\cf0 \
\
\
\cf2 public\cf3  \cf2 class\cf3  \cf5 Player\cf3  \cf6 \{\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3     \cf0 \
\cf3     \cf2 private\cf3  \cf5 \ul \ulc5 Card\cf6 \ulnone []\cf3  \cf7 hand\cf4 ;\cf3  \cf8 // All of the cards held by a player\cf0 \
\cf3     \cf2 private\cf3  \cf5 String\cf3  \cf7 name\cf4 ;\cf0 \
\cf3     \cf2 private\cf3  \cf2 boolean\cf3  \cf7 active\cf4 ;\cf0 \
\cf3     \cf0 \
\cf3     \cf2 public\cf3  \cf9 Player\cf6 (\cf5 String\cf3  \cf10 name\cf6 )\cf3  \cf6 \{\cf0 \
\cf3         \cf0 \
\cf3         \cf2 this\cf4 .\cf7 name\cf3  \cf4 =\cf3  \cf10 name\cf4 ;\cf0 \
\cf3         \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf7 \ulc7 hand\cf3 \ulnone  \cf4 =\cf3  \cf2 new\cf3  \cf5 \ul \ulc5 Card\cf6 \ulnone [\cf11 0\cf6 ]\cf4 ;\cf0 \
\cf3         \cf2 this\cf4 .\cf7 active\cf3  \cf4 =\cf3  \cf2 true\cf4 ;\cf0 \
\cf3     \cf6 \}\cf0 \
\
\cf3     \cf8 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf8      * The name of the Player.\cf0 \
\cf8      */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3     \cf2 public\cf3  \cf5 String\cf3  \cf9 getName\cf6 ()\cf3  \cf6 \{\cf0 \
\
\cf3         \cf2 return\cf3  \cf7 name\cf4 ;\cf0 \
\cf3     \cf6 \}\cf0 \
\cf3     \cf0 \
\cf3     \cf8 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf8      * The number of Cards the Player has.\cf0 \
\cf8      */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3     \cf2 public\cf3  \cf2 int\cf3  \cf9 getHandSize\cf6 ()\cf3  \cf6 \{\cf0 \
\cf3         \cf0 \
\cf3         \cf2 return\cf3  \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf7 \ulc7 hand\cf4 \ulnone .\cf3 length\cf4 ;\cf0 \
\cf3     \cf6 \}\cf0 \
\
\cf3     \cf8 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf8      * Return the player whether is active or not\cf0 \
\cf8    	 */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3     \cf2 public\cf3  \cf2 boolean\cf3  \cf9 isactive\cf6 ()\cf3  \cf6 \{\cf0 \
\
\cf3         \cf2 return\cf3  \cf7 active\cf4 ;\cf0 \
\cf3     \cf6 \}\cf0 \
\
\cf3     \cf8 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf8      * Sets whether the Player is still in a game.\cf0 \
\cf8      */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3     \cf2 public\cf3  \cf2 void\cf3  \cf9 setactive\cf6 (\cf2 boolean\cf3  \cf10 active\cf6 )\cf3  \cf6 \{\cf0 \
\
\cf3         \cf2 this\cf4 .\cf7 active\cf3  \cf4 =\cf3  \cf10 active\cf4 ;\cf0 \
\cf3     \cf6 \}\cf0 \
\cf3     \cf0 \
\cf3     \cf8 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf8      * Returns the Card a Player has at a given index in their array of Cards.\cf0 \
\cf8      * \cf0 \
\cf8      * 
\f1\b \cf12 @param
\f0\b0 \cf8  index, \ul int\cf0 \ulnone \
\cf8      * 
\f1\b \cf12 @return
\f0\b0 \cf8  the Card at that index\cf0 \
\cf8      */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3     \cf2 public\cf3  \cf5 \ul \ulc5 Card\cf3 \ulnone  \cf9 getCardAtIndex\cf6 (\cf2 int\cf3  \cf10 index\cf6 )\cf3  \cf6 \{\cf3       \cf0 \
\cf3         \cf2 return\cf3  \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf7 \ulc7 hand\cf6 \ulnone [\cf10 index\cf6 ]\cf4 ;\cf0 \
\cf3     \cf6 \}\cf0 \
\cf3     \cf0 \
\cf3     \cf0 \
\cf3     \cf8 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf8      * Adds a given card to the end of a players hand.\cf0 \
\cf8      * \cf0 \
\cf8      * 
\f1\b \cf12 @param
\f0\b0 \cf8  newCard \cf0 \
\cf8      */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3     \cf2 public\cf3  \cf2 void\cf3  \cf9 giveCard\cf6 (\cf5 \ul \ulc5 Card\cf3 \ulnone  \cf10 newCard\cf6 )\cf3  \cf6 \{\cf0 \
\cf3         \cf0 \
\cf3         \cf5 \ul \ulc5 Card\cf6 \ulnone []\cf3  \cf13 newHand\cf3  \cf4 =\cf3  \cf2 new\cf3  \cf5 \ul \ulc5 Card\cf6 \ulnone [\cf2 \ul \ulc2 this\cf4 \ulc4 .\cf7 \ulc7 hand\cf4 \ulnone .\cf3 length\cf4 +\cf11 1\cf6 ]\cf4 ;\cf0 \
\cf3         \cf0 \
\cf3         \cf2 for\cf3  \cf6 (\cf2 int\cf3  \cf13 i\cf3  \cf4 =\cf3  \cf11 0\cf4 ;\cf3  \cf14 i\cf3  \cf4 <\cf3  \cf7 \ul \ulc7 hand\cf4 \ulnone .\cf3 length\cf4 ;\cf3  \cf14 i\cf4 ++\cf6 )\cf3  \cf6 \{\cf0 \
\cf3             \cf0 \
\cf3             \cf14 newHand\cf6 [\cf14 i\cf6 ]\cf3  \cf4 =\cf3  \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf7 \ulc7 hand\cf6 \ulnone [\cf14 i\cf6 ]\cf4 ;\cf0 \
\cf3         \cf6 \}\cf0 \
\cf3         \cf0 \
\cf3         \cf14 newHand\cf6 [\cf7 \ul \ulc7 hand\cf4 \ulnone .\cf3 length\cf6 ]\cf3  \cf4 =\cf3  \cf10 newCard\cf4 ;\cf0 \
\cf3         \cf0 \
\cf3         \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf7 \ulc7 hand\cf3 \ulnone  \cf4 =\cf3  \cf14 newHand\cf4 ;\cf0 \
\cf3     \cf6 \}\cf0 \
\cf3     \cf0 \
\cf3     \cf8 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf8      * Removes the first card from a player's hand and returns it.\cf0 \
\cf8      * \cf0 \
\cf8      * 
\f1\b \cf12 @return
\f0\b0 \cf8  Card, takenCard\cf0 \
\cf8      */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3     \cf2 public\cf3  \cf5 \ul \ulc5 Card\cf3 \ulnone  \cf9 takeCard\cf6 ()\cf3  \cf6 \{\cf0 \
\cf3         \cf0 \
\cf3         \cf5 \ul \ulc5 Card\cf3 \ulnone  \cf13 takenCard\cf3  \cf4 =\cf3  \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf7 \ulc7 hand\cf6 \ulnone [\cf11 0\cf6 ]\cf4 ;\cf3         \cf0 \
\cf3         \cf5 \ul \ulc5 Card\cf6 \ulnone []\cf3  \cf13 newHand\cf3  \cf4 =\cf3  \cf2 new\cf3  \cf5 \ul \ulc5 Card\cf6 \ulnone [\cf2 \ul \ulc2 this\cf4 \ulc4 .\cf7 \ulc7 hand\cf4 \ulnone .\cf3 length\cf4 -\cf11 1\cf6 ]\cf4 ;\cf0 \
\cf3         \cf0 \
\cf3         \cf2 for\cf3  \cf6 (\cf2 int\cf3  \cf13 i\cf3  \cf4 =\cf3  \cf11 0\cf4 ;\cf3  \cf14 i\cf3  \cf4 <\cf3  \cf14 newHand\cf4 .\cf3 length\cf4 ;\cf3  \cf14 i\cf4 ++\cf6 )\cf3  \cf6 \{\cf0 \
\cf3             \cf0 \
\cf3             \cf14 newHand\cf6 [\cf14 i\cf6 ]\cf3  \cf4 =\cf3  \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf7 \ulc7 hand\cf6 \ulnone [\cf14 i\cf4 +\cf11 1\cf6 ]\cf4 ;\cf0 \
\cf3             \cf0 \
\cf3         \cf6 \}\cf0 \
\cf3         \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf7 \ulc7 hand\cf3 \ulnone  \cf4 =\cf3  \cf14 newHand\cf4 ;\cf0 \
\cf3         \cf0 \
\cf3         \cf2 if\cf3  \cf6 (\cf2 this\cf4 .\cf15 getHandSize\cf6 ()\cf3  \cf4 ==\cf3  \cf11 0\cf6 )\cf3  \cf6 \{\cf0 \
\cf3             \cf0 \
\cf3             \cf2 this\cf4 .\cf7 active\cf3  \cf4 =\cf3  \cf2 false\cf4 ;\cf0 \
\cf3         \cf6 \}\cf3       \cf0 \
\cf3         \cf2 return\cf3  \cf14 takenCard\cf4 ;\cf0 \
\cf3     \cf6 \}\cf0 \
\cf3     \cf0 \
\cf3     \cf8 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf8      * Returns the Player's top card, without removing that card from \cf0 \
\cf8      * the ones they hold\cf0 \
\cf8      * \cf0 \
\cf8      * 
\f1\b \cf12 @return
\f0\b0 \cf8  the top Card\cf0 \
\cf8      */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3     \cf2 public\cf3  \cf5 \ul \ulc5 Card\cf3 \ulnone  \cf9 viewTopCard\cf6 ()\cf3  \cf6 \{\cf0 \
\cf3         \cf0 \
\cf3         \cf2 return\cf3  \cf2 \ul \ulc2 this\cf4 \ulc4 .\cf7 \ulc7 hand\cf6 \ulnone [\cf11 0\cf6 ]\cf4 ;\cf0 \
\cf3     \cf6 \}\cf0 \
\cf3     \cf0 \
\pard\pardeftab720\partightenfactor0
\cf6 \}}