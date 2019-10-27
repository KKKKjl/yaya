import Vue from 'vue';
import Svgicon from '@/components/Svgicon';

Vue.component('svg-icon', Svgicon)

const requireAll = requireContext => requireContext.keys().map(requireContext);
const req = require.context('./svgs', true, /\.svg$/);
requireAll(req);