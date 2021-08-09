/*
 * Waltz - Enterprise Architecture
 * Copyright (C) 2016, 2017, 2018, 2019 Waltz open source project
 * See README.md for more information
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
 * See the License for the specific
 *
 */

import template from './welcome.html';
import {sidebarVisible} from "../navbar/sidebar-store";


const initialState = {
    appGroupSubscriptions: [],
    panels: [],
    history: []
};


function controller($document,
                    appGroupStore,
                    localStorageService) {

    const vm = Object.assign(this, initialState);

    vm.$onInit = () => sidebarVisible.set(false);

    appGroupStore
        .findMyGroupSubscriptions()
        .then(groupSubscriptions => vm.appGroupSubscriptions = groupSubscriptions);

    vm.history = localStorageService
            .get('history_2') || [];

    $document[0].title = `Waltz`;

}

controller.$inject = [
    '$document',
    'AppGroupStore',
    'localStorageService'
];


const view = {
    controller,
    controllerAs: 'ctrl',
    template
};


export default view;