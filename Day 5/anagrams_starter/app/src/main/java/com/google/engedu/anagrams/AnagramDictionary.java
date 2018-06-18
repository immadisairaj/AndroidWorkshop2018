/* Copyright 2016 Google Inc.
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

package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();

    private static int wordLength = DEFAULT_WORD_LENGTH;

    public ArrayList<String> wordList = new ArrayList<>();
    public HashSet<String> wordSet = new HashSet<>();
    public HashMap<String,ArrayList<String>> lettersToWord = new HashMap<>();
    public HashMap<Integer,ArrayList<String>> sizeToWords = new HashMap<>();

    public AnagramDictionary(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordList.add(word);

            wordSet.add(word);
            String sortedWord = sortLetters(word);

            if (lettersToWord.containsKey(sortedWord)) {
                lettersToWord.get(sortedWord).add(word);
            }
            else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(word);
                lettersToWord.put(sortedWord, temp);
            }
        }
    }

    public boolean isGoodWord(String word, String base) {
        return wordSet.contains(word) && !word.contains(base);
    }

    public List<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();
        String a = sortLetters(targetWord);
        for(String word : wordList) {
            if (word.length() == targetWord.length()) {
                String b = sortLetters(word);
                if (a.equals(b)) {
                    result.add(word);
                }
            }
        }
        return result;
    }

    public List<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();

        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        for (int i=0; i<alphabets.length(); i++) {
            String temp = word;

            temp += alphabets.charAt(i);
            String key = sortLetters(temp);

            if (lettersToWord.containsKey(key)) {
                ArrayList<String> tempList = lettersToWord.get(key);

                for (String test : tempList) {
                    if(!isGoodWord(test,word)) {
                        tempList.remove(test);
                    }
                }

                result.addAll(tempList);
            }
        }
        return result;
    }

    public String pickGoodStarterWord() {
        int length;
        String randomWord;
        //ArrayList<String> temp = sizeToWords.get(wordLength);
        do {
            randomWord = wordList.get(random.nextInt(wordList.size()));
            //randomWord = temp.get(random.nextInt(temp.size()));
            length = getAnagramsWithOneMoreLetter(randomWord).size();
            } while (length < MIN_NUM_ANAGRAMS);
            if (wordLength < MAX_WORD_LENGTH) {
                wordLength++;
            }
            return randomWord;
    }

    public String sortLetters(String target) {
        char[] tempArray = target.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
