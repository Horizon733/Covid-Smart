package com.example.covidsmart.customview;

import java.util.List;
import com.example.covidsmart.tflite.Classifier.Recognition;

public interface ResultsView {
  public void setResults(final List<Recognition> results);
}
