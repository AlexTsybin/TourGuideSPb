package com.alextsy.tourguidespb;

/**
 * Created by os_mac on 29.10.17.
 */

public class Word {
    /** String resource ID for the default translation of the word */
    private int mDefaultTranslationId;

    /** String resource ID for the Miwok translation of the word */
    private int mMiwokTranslationId;

    private int mPriceId;

    private int mGeoId;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslationId is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param miwokTranslationId is the string resource Id for the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     */
    public Word(int defaultTranslationId, int miwokTranslationId, int price, int imageResourceId,
                int geoId) {
        mDefaultTranslationId = defaultTranslationId;
        mMiwokTranslationId = miwokTranslationId;
        mPriceId = price;
        mImageResourceId = imageResourceId;
        mGeoId = geoId;
    }

    /**
     * Get the string resource ID for the default translation of the word.
     */
    public int getDefaultTranslationId() {
        return mDefaultTranslationId;
    }

    /**
     * Get the string resource ID for the Miwok translation of the word.
     */
    public int getMiwokTranslationId() {
        return mMiwokTranslationId;
    }

    public int getPriceId() {
        return mPriceId;
    }

    public int getGeoId() {
        return mGeoId;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
