/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratesproject.interfaces;

import piratesproject.models.ResponseModel;

public interface NetworkResponseHandler {
        void onResponseReceived(ResponseModel response);
    }